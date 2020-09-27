package xyz.hpwyx.manager.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.hpwyx.manager.common.AlipayConfig;
import xyz.hpwyx.manager.mapper.BOrderDetailMapper;
import xyz.hpwyx.manager.mapper.BOrderMapper;
import xyz.hpwyx.manager.pojo.BOrder;
import xyz.hpwyx.manager.pojo.BOrderDetail;
import xyz.hpwyx.manager.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private BOrderMapper dao;
    @Autowired
    private BOrderDetailMapper orderDetailMapper;
    @Override
    public int countOrder() {
        return dao.countOrder ();
    }

    @Override
    public List<BOrder> getOrderList(BOrder order) {
        return dao.findList (order);
    }

    @Override
    public int insertOrderDetail(BOrderDetail detail) {
        return orderDetailMapper.insertSelective (detail);
    }

    @Override
    public BOrder getPayById(String id) {
        return null;
    }


    @Override
    public String createOrder(@RequestParam("orderNo") String orderNo, @RequestParam("amount") double amount, @RequestParam("body") String body) throws AlipayApiException {
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayClient alipayClient = new DefaultAlipayClient (AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel ();
        model.setSubject (body);
        model.setOutTradeNo (orderNo);
        model.setTotalAmount (String.valueOf (amount));
        model.setProductCode ("QUICK_MSECURITY_PAY");
        model.setPassbackParams ("公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数");

        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest ali_request = new AlipayTradeAppPayRequest ();
        ali_request.setBizModel (model);
        ali_request.setNotifyUrl (AlipayConfig.notify_url);// 回调地址
        ali_request.setReturnUrl (AlipayConfig.return_url);
        AlipayTradeAppPayResponse ali_response = alipayClient.sdkExecute (ali_request);
        //就是orderString 可以直接给客户端请求，无需再做处理。
        return ali_response.getBody ();
    }

    @Override
    public boolean notify(@RequestParam("tradeStatus") String tradeStatus, @RequestParam("orderNo") String orderNo, @RequestParam("tradeNo") String tradeNo) {
        if ("TRADE_FINISHED".equals (tradeStatus)
                || "TRADE_SUCCESS".equals (tradeStatus)) {
            // 支付成功，根据业务逻辑修改相应数据的状态
            System.out.println ("orderNo" + orderNo);
            System.out.println ("tradeNo" + tradeNo);
//            BOrder payById = dao.selectByPrimaryKey (orderNo);
            BOrder payById = dao.selectByPrimaryKey (1);
//            payById.setoPlatformorderid (tradeNo);
            payById.setoStatus (1);
            dao.updateByPrimaryKey (payById);


            return true;
        }
        System.out.println ("支付失败notify");
        return false;
    }

    @Override
    public boolean returnU(@RequestParam("tradeStatus") String tradeStatus, @RequestParam("orderNo") String orderNo, @RequestParam("tradeNo") String tradeNo) {
        if ("TRADE_FINISHED".equals (tradeStatus)
                || "TRADE_SUCCESS".equals (tradeStatus)) {
            // 支付成功，根据业务逻辑修改相应数据的状态
            System.out.println ("orderNo" + orderNo);
            System.out.println ("tradeNo" + tradeNo);
            System.out.println ("orderNo" + orderNo);
            System.out.println ("tradeNo" + tradeNo);
//            BOrder payById = dao.selectByPrimaryKey (orderNo);
//            payById.setoPlatformorderid (tradeNo);
//            payById.setoStatus (1);
//            dao.updateByPrimaryKey (payById);
//
//            String aDouble = payById.getoAmount () + "";
//            System.out.println (aDouble);
            return true;
        }
        System.out.println ("支付失败notify");
        return false;
    }

    @Override
    public boolean rsaCheckV1(HttpServletRequest request) {
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
