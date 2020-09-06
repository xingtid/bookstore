package xyz.hpwyx.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.hpwyx.manager.pojo.BBookType;
import xyz.hpwyx.manager.service.impl.BookTypeServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {
@Autowired
private BookTypeServiceImpl bookTypeService;
    @RequestMapping(value = "admin")
    public String admin(Model model, HttpServletRequest request) {
        return "/admin";
    }

    @RequestMapping(value = "adminType")
    public String adminType(Model model, HttpServletRequest request) {
        List<BBookType> allType = bookTypeService.findAllType ();
        model.addAttribute ("typeList",allType);
        return "/type";
    }

}
