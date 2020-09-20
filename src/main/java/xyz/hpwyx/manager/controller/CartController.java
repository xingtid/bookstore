package xyz.hpwyx.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.hpwyx.manager.common.Result;
import xyz.hpwyx.manager.pojo.*;
import xyz.hpwyx.manager.service.BookService;
import xyz.hpwyx.manager.service.impl.CartServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;


@Controller
public class CartController {
    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private BookService bookService;
    @ResponseBody
    @RequestMapping(value = "addBook/{bookId}/{count}")
    public Result addBook(@PathVariable Integer bookId,@PathVariable Integer count, Model model, HttpServletRequest request) {
        BUser userinfo = (BUser) request.getSession ().getAttribute ("USERINFO");
        if (userinfo == null){
            return Result.fail ("请先登录");
        }
        //查找商品信息
        BBook bBook = bookService.get (bookId);
        BShopCart cart = new BShopCart ();
        cart.setcBookId (bookId);
        cart.setcCount (count);
        cart.setcUserId (userinfo.getuId ());
        cart.setcPrice (bBook.getbPrice ());
        cart.setcAll (bBook.getbPrice ().multiply (new BigDecimal (count)));
        cartService.insertCart (cart);
        return Result.success ();
    }
    @RequestMapping(value = "toShopCart")
    public String toShopCart( Model model, HttpServletRequest request) {
        BUser userinfo = (BUser) request.getSession ().getAttribute ("USERINFO");
        //判断是否登录
        if (userinfo == null){
            model.addAttribute ("msg","请先登录");
            return "shopCart";
        }
        BShopCart cart = new BShopCart ();
        cart.setcUserId (userinfo.getuId ());
        //
        List<CartWithBook> cartList = cartService.findCartList (cart);
        model.addAttribute ("cartList",cartList);
        return "shopCart";
    }
    @RequestMapping(value = "delCar/{id}")
    @ResponseBody
    public String delCar( @PathVariable Integer id,Model model, HttpServletRequest request) {
        BShopCart cart = new BShopCart ();
        cart.setcId (id);
        //
        cartService.delCart (cart);
        return "200";
    }
}
