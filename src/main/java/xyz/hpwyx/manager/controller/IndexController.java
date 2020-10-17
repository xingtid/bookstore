package xyz.hpwyx.manager.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.hpwyx.manager.common.JsonUtils;
import xyz.hpwyx.manager.common.RedisUtil;
import xyz.hpwyx.manager.pojo.*;
import xyz.hpwyx.manager.service.BookService;
import xyz.hpwyx.manager.service.BookTypeService;
import xyz.hpwyx.manager.service.impl.CartServiceImpl;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author tid
 * @create 2019-03-16 15:02
 **/
@Controller
public class IndexController {
    @Autowired
    private BookTypeService bookTypeService;
    @Autowired
    private BookService bookService;
    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping(value = {"/","index.html"})
    public String index(Model model, HttpServletRequest request) {
        List<BBookType> allType = bookTypeService.findAllType ();
        request.getSession ().setAttribute ("typeList", allType);
        findCart (model, request);
        BBook bBook = new BBook ();
        bBook.setLimit (9);
        List<BBook> bookList = bookService.findBookList (bBook);
        model.addAttribute ("bookList",bookList);
//        try {
//            String json3 = redisUtil.hget ("INDEX", "index_pic1");
//            if (StringUtils.isNotBlank (json3)) {
//                System.out.println ("取出缓存");
//                request.setAttribute ("index_book", JsonUtils.jsonToList (json3, BBook.class));
//            } else {
//                List<BBook> bookList = bookService.findBookList ();
////                List<XIndex> xResult = indexServiceFigen.showPic ();
//                request.setAttribute ("index_book", "");
//
//                redisUtil.hset ("INDEX", "index_book", JsonUtils.objectToJson (bookList));
//                redisUtil.expire ("INDEX", 20000, 0);
//            }
//        } catch (Exception e) {
//            e.printStackTrace ();
//        }
        return "index";
    }

    //  全局跳转
    @RequestMapping("/{page}.html")
    public String showPage2(@PathVariable String page, HttpServletRequest request, Model model) {
        String url = request.getHeader ("REFERER");
        System.out.println (url);
        List<BBookType> allType = bookTypeService.findAllType ();
        findCart (model, request);
        request.getSession ().setAttribute ("typeList", allType);
        model.addAttribute ("REFERER", url);
        return page;
    }
    public void findCart(Model model, HttpServletRequest request) {
        BUser userinfo = (BUser) request.getSession ().getAttribute ("USERINFO");
        if (userinfo != null){
            BShopCart cart = new BShopCart ();
            cart.setcUserId (userinfo.getuId ());
            List<CartWithBook> cartList = cartService.findCartList (cart);
            BigDecimal sum = new BigDecimal (0);
            //计算购物车中总金额
            for (CartWithBook item : cartList) {
                sum =  sum.add (item.getcAll ());
            }
            request.getSession ().setAttribute ("cartList", cartList);
            request.getSession ().setAttribute ("sumPrice", sum);
            model.addAttribute ("cartList",cartList);
            model.addAttribute ("sumPrice",sum);
        }
    }
}
