package xyz.hpwyx.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.hpwyx.manager.pojo.BUser;
import xyz.hpwyx.manager.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/getMyUser")
    public String getMyUser(Model model ,HttpServletRequest request) {
        BUser userinfo = (BUser) request.getSession ().getAttribute ("USERINFO");
        BUser user = userService.findUserByUserName (userinfo);
        model.addAttribute ("user",user);
        return "userInfo";
    }
    @RequestMapping("/saveUserInfo")
    public String saveUserInfo( BUser user,Model model ,HttpServletRequest request) {
        BUser userinfo = (BUser) request.getSession ().getAttribute ("USERINFO");
        BUser user2 = userService.findUserByUserName (userinfo);
        user2.setuAddress (user.getuAddress ());
        user2.setuEducation (user.getuEducation ());
        user2.setuName (user.getuName ());
        user2.setuPhone (user.getuPhone ());
        user2.setuEmail (user.getuEmail ());
        userService.updateUser(user2);
        model.addAttribute ("user",user2);
        return "redirect:/getMyUser";
    }
}
