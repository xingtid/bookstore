package xyz.hpwyx.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.hpwyx.manager.pojo.*;
import xyz.hpwyx.manager.service.CommentService;
import xyz.hpwyx.manager.service.impl.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private BookTypeServiceImpl bookTypeService;
    @Autowired
    private BookServiceImpl bookService;
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CommentServiceImpl commentService;
    @RequestMapping(value = "admin")
    public String admin(Model model, HttpServletRequest request) {
        int bookCount = bookService.countBookByType (new BBook ());
        model.addAttribute ("bookCount",bookCount);
        int orderCount = orderService.countOrder ();
        model.addAttribute ("orderCount",orderCount);
        int countUser = userService.countUser ();
        model.addAttribute ("countUser",countUser);
        return "/admin";
    }

    @RequestMapping(value = "adminType")
    public String adminType(Model model, HttpServletRequest request) {
        List<BBookType> allType = bookTypeService.findAllType ();
        model.addAttribute ("typeList",allType);
        return "typeadmin";
    }
    @RequestMapping(value = "adminUser")
    public String adminUser(BUser user, Model model, HttpServletRequest request) {
        List<BUser> list = userService.findList (user);
        model.addAttribute ("userList",list);
        return "useradmin";
    }
    @RequestMapping(value = "adminOrder")
    public String adminOrder(BOrder order, Model model, HttpServletRequest request) {
        List<BOrder> list = orderService.getOrderList (order);
        for (BOrder item : list) {
            BUser bUser = userService.selectByPrimaryKey (item.getoUserId ());
            item.setUserName (bUser.getuName ());
        }
        model.addAttribute ("orderList",list);
        return "orderadmin";
    }
    @RequestMapping(value = "adminGood")
    public String adminGood(BBook bBook, Model model, HttpServletRequest request) {
        List<BBook> bookList = bookService.findList (bBook);
        model.addAttribute ("goodList",bookList);
        List<BBookType> allType = bookTypeService.findAllType ();
        model.addAttribute ("typeList",allType);
        return "goodadmin";
    }
    @RequestMapping(value = "adminComment")
    public String adminCollection(Model model, HttpServletRequest request) {
        List<BComment> list = commentService.findList (new BComment ());
        model.addAttribute ("commentList",list);
        return "commentadmin";
    }
    @RequestMapping(value = "adminSearch")
    public String adminSearch(String name, Model model, HttpServletRequest request) {

        return "typeadmin";
    }
    @RequestMapping(value = "setAdmin/{id}/{isAdmin}")
    public String adminSearch(@PathVariable Integer id,@PathVariable Integer isAdmin, Model model, HttpServletRequest request) {
        BUser user = new BUser ();
        user.setuId (id);
        user.setuIsAdmin (isAdmin.toString ());
        userService.updateUser(user);
        return "redirect:/adminUser";
    }


}
