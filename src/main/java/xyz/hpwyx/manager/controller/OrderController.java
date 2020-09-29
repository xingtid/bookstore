package xyz.hpwyx.manager.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.hpwyx.manager.common.AlipayConfig;
import xyz.hpwyx.manager.common.TokenUtils;
import xyz.hpwyx.manager.pojo.*;
import xyz.hpwyx.manager.service.impl.CartServiceImpl;
import xyz.hpwyx.manager.service.impl.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

@Controller
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private CartServiceImpl cartService;

    @RequestMapping("/getMyOrder")
    public String getMyOrder(Model model, HttpSession session) {
        BUser userinfo = (BUser) session.getAttribute ("USERINFO");
        if (userinfo == null) {
            return "/login";
        }
        BOrder order = new BOrder ();
        order.setoUserId (userinfo.getuId ());
        List<BOrder> orderList = orderService.getOrderList (order);
        model.addAttribute ("orderList", orderList);
        return "/userOrder";
    }

    /**
     * 创建订单
     */
    @RequestMapping("/createOrderDetail")
    public String createOrderDetail(BOrder order, Model model, HttpSession session) {
        BUser userinfo = (BUser) session.getAttribute ("USERINFO");
//        List<Integer> id = order.getId ();
        if (userinfo == null) {
            return "/login";
        }
        BShopCart cart = new BShopCart ();
        cart.setcUserId (userinfo.getuId ());
        List<CartWithBook> cartList = cartService.findCartList (cart);
        List<BOrderDetail> details = new ArrayList<> ();
        //创建订单明细
        BigDecimal totalPrice = new BigDecimal (0);
        for (CartWithBook cartWithBook : cartList) {
            BOrderDetail detail = new BOrderDetail ();
            detail.setOdBookId (cartWithBook.getcBookId ());
            detail.setOdCount (cartWithBook.getcCount ());
            detail.setOdPrice (cartWithBook.getSingalPrice ());
            detail.setOdMark (userinfo.getuId ().toString ());
            details.add (detail);
            orderService.insertOrderDetail(detail);
            BShopCart cart1 = new BShopCart ();
            cart1.setcId (cartWithBook.getId ());
            cartService.delCart (cart1);
            //循环每件商品 计算总价
            BigDecimal multiply = new BigDecimal (cartWithBook.getcCount ()).multiply (cartWithBook.getSingalPrice ());
            totalPrice = totalPrice.add (multiply);
        }
        //创建订单
        BOrder order2 = new BOrder ();
        order2.setoUserId (userinfo.getuId ());
        order2.setoAmount (totalPrice);
        order2.setoOrderNo (TokenUtils.getPayToken ());
        order2.setoStartDate (new Date ());
        order2.setoStatus (1);
        orderService.insertOrder (order2);
        model.addAttribute ("order",order2);
        model.addAttribute ("orderDetail",cartList);
        return "/orderCommit";
    }

    /**
     * 创建订单
     */
    @RequestMapping("/createOrder/{amount}/{orderNo}")
    @ResponseBody
    public String createOrder(@PathVariable double amount,@PathVariable String orderNo, HttpServletResponse response, HttpSession session) throws Exception {

        BUser userinfo = (BUser) session.getAttribute ("USERINFO");
        if (userinfo == null) {
            return "请先登录";
        }
        AlipayClient alipayClient = new DefaultAlipayClient (AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel ();

        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest ali_request = new AlipayTradeAppPayRequest ();
        ali_request.setBizModel (model);
        // 回调地址
        ali_request.setNotifyUrl (AlipayConfig.notify_url);
        //就是orderString 可以直接给客户端请求，无需再做处理。


        System.out.println ("no:" + orderNo);
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest ();
        alipayRequest.setReturnUrl (AlipayConfig.return_url); //同步通知url
        alipayRequest.setNotifyUrl (AlipayConfig.notify_url);//异步通知url
        alipayRequest.setBizContent ("{\"out_trade_no\":\"" + orderNo + "\","
                + "\"total_amount\":\"" + amount + "\","
                + "\"subject\":\"" + "测试" + "\","
                + "\"body\":\"" + "会员支付" + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String webForm = "";//输出页面的表单
        webForm = alipayClient.pageExecute (alipayRequest).getBody ();
        response.setContentType ("text/html;charset=" + AlipayConfig.charset);
        response.getWriter ().write (webForm);//直接将完整的表单html输出到页面
        response.getWriter ().flush ();
        response.getWriter ().close ();
        return webForm;
    }

    /**
     * 支付异步通知
     * 接收到异步通知并验签通过后，一定要检查通知内容，
     * 包括通知中的app_id、out_trade_no、total_amount是否与请求中的一致，并根据trade_status进行后续业务处理。
     * https://docs.open.alipay.com/194/103296
     */
    @ResponseBody
    @RequestMapping("/callBack/notifyUrl")
    public String notify(HttpServletRequest request, HttpSession session) {
        // 验证签名
        boolean flag = rsaCheck (request);
        System.out.println ("flag = " + flag);
//        if (flag) {
        String tradeStatus = request.getParameter ("trade_status"); // 交易状态
        String outTradeNo = request.getParameter ("out_trade_no"); // 商户订单号
        String tradeNo = request.getParameter ("trade_no"); // 支付宝订单号
        /**
         * 还可以从request中获取更多有用的参数，自己尝试
         */
//            boolean notify = vipServiceFigen.notify (tradeStatus, outTradeNo, tradeNo);
        if (true) {
            BUser userinfo = (BUser) session.getAttribute ("USERINFO");
            if (userinfo == null) {
                return "fail";
            }
            return "success";
        }
//        }
        return "fail";
    }

    /**
     * 同步
     *
     * @param request
     * @return
     */
    @RequestMapping("/callBack/returnUrl")
    public String returnUrl(HttpServletRequest request) {
        String tradeStatus = request.getParameter ("trade_status"); // 交易状态
        String outTradeNo = request.getParameter ("out_trade_no"); // 商户订单号
        String tradeNo = request.getParameter ("trade_no"); // 支付宝订单号
        System.out.println ("tradeNo = " + tradeNo);
        boolean notify = orderService.notify ("TRADE_SUCCESS", outTradeNo, tradeNo);
        // 验证签名
        boolean flag = rsaCheck (request);
        if (flag) {

        } else {

        }
        return "redirect:/";

    }

    public boolean rsaCheck(HttpServletRequest request) {
        try {
            Map<String, String> params = new HashMap<> ();
            Map<String, String[]> requestParams = request.getParameterMap ();
            for (Iterator iter = requestParams.keySet ().iterator (); iter.hasNext (); ) {
                String name = (String) iter.next ();
                String[] values = requestParams.get (name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                }
                params.put (name, valueStr);
            }

            boolean verifyResult = AlipaySignature.rsaCheckV1 (params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
            return verifyResult;
        } catch (AlipayApiException e) {
            return false;
        }
    }
}
