package xyz.hpwyx.manager.service;

import com.alipay.api.AlipayApiException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.hpwyx.manager.pojo.BOrder;

import javax.servlet.http.HttpServletRequest;

@Service
public interface OrderService {
    int countOrder();
    /**
     * 根据ID获取订单
     * @param id
     * @return
     */
    @RequestMapping("/getPayById")
    BOrder getPayById(@RequestParam("id") String id);

    /**
     * @param orderNo: 订单编号
     * @param amount:  实际支付金额
     * @param body:    订单描述
     * @return
     * @Description: 创建支付宝订单
     * @Author:
     * @Date: 2019/8/1
     */
    @RequestMapping("/creataeOrder")
    String createOrder(@RequestParam("orderNo") String orderNo, @RequestParam("amount") double amount, @RequestParam("body") String body) throws AlipayApiException;

    /**
     * @param tradeStatus: 支付宝交易状态
     * @param orderNo:     订单编号
     * @param tradeNo:     支付宝订单号
     * @return
     * @Description:
     * @Author:
     * @Date: 2019/8/1
     */
    @RequestMapping("/notify")
    boolean notify(@RequestParam("tradeStatus") String tradeStatus, @RequestParam("orderNo") String orderNo, @RequestParam("tradeNo") String tradeNo);


    @RequestMapping("/returnU")
    boolean returnU(@RequestParam("tradeStatus") String tradeStatus, @RequestParam("orderNo") String orderNo, @RequestParam("tradeNo") String tradeNo);

    /**
     * @param request
     * @return
     * @Description: 校验签名
     * @Author:
     * @Date: 2019/8/1
     */
    @RequestMapping("/rsaCheckV1")
    boolean rsaCheckV1(HttpServletRequest request);
}