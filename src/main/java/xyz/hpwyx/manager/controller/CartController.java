package xyz.hpwyx.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.hpwyx.manager.common.Result;
import xyz.hpwyx.manager.pojo.BShopCart;
import xyz.hpwyx.manager.pojo.BUser;
import xyz.hpwyx.manager.service.impl.CartServiceImpl;

import javax.servlet.http.HttpServletRequest;


@Controller
public class CartController {
    @Autowired
    private CartServiceImpl cartService;
    @ResponseBody
    @RequestMapping(value = "addBook/{bookId}/{count}")
    public Result addBook(@PathVariable Integer bookId,@PathVariable Integer count, Model model, HttpServletRequest request) {
        BUser userinfo = (BUser) request.getSession ().getAttribute ("USERINFO");
        BShopCart cart = new BShopCart ();
        cart.setcBookId (bookId);
        cart.setcCount (count);
        cart.setcUserId (userinfo.getuId ());
        cartService.insertCart (cart);
        return Result.success ();
    }
}
