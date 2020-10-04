package xyz.hpwyx.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.hpwyx.manager.pojo.BBook;
import xyz.hpwyx.manager.pojo.BBookType;
import xyz.hpwyx.manager.pojo.BUser;
import xyz.hpwyx.manager.service.impl.BookServiceImpl;
import xyz.hpwyx.manager.service.impl.BookTypeServiceImpl;
import xyz.hpwyx.manager.service.impl.OrderServiceImpl;
import xyz.hpwyx.manager.service.impl.UserServiceImpl;

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
    @RequestMapping(value = "adminGood")
    public String adminGood(Model model, HttpServletRequest request) {
        List<BBook> bookList = bookService.findList ();
        model.addAttribute ("goodList",bookList);
        List<BBookType> allType = bookTypeService.findAllType ();
        model.addAttribute ("typeList",allType);
        return "goodadmin";
    }
    @RequestMapping(value = "adminSearch")
    public String adminSearch(String name, Model model, HttpServletRequest request) {

        return "typeadmin";
    }
}
