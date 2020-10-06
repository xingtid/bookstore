package xyz.hpwyx.manager.service;

import com.alipay.api.AlipayApiException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.hpwyx.manager.pojo.BOrder;
import xyz.hpwyx.manager.pojo.BOrderDetail;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface OrderService {
    //计算订单数
    int countOrder();

    List<BOrder> getOrderList(BOrder order);

    int insertOrderDetail(BOrderDetail detail);
    /**
     * 根据ID获取订单
     * @param id
     * @return
     */
    BOrder getOrderById(Integer id);


    int insertOrder(BOrder order);

    /**
     * @param orderNo: 订单编号
     * @param amount:  实际支付金额
     * @param body:    订单描述
     * @return
     * @Description: 创建支付宝订单
     * @Author:
     * @Date: 2019/8/1
     */
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
    boolean notify(@RequestParam("tradeStatus") String tradeStatus, @RequestParam("orderNo") String orderNo, @RequestParam("tradeNo") String tradeNo);


    boolean returnU(@RequestParam("tradeStatus") String tradeStatus, @RequestParam("orderNo") String orderNo, @RequestParam("tradeNo") String tradeNo);

    /**
     * @param request
     * @return
     * @Description: 校验签名
     * @Author:
     * @Date: 2019/8/1
     */
    boolean rsaCheckV1(HttpServletRequest request);
}
