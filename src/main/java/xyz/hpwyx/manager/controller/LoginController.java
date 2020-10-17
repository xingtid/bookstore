package xyz.hpwyx.manager.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.hpwyx.manager.common.Result;
import xyz.hpwyx.manager.pojo.BUser;
import xyz.hpwyx.manager.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/baseLogin")
    public Result login(BUser person, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject ();
        //1.验证参数
        if (person.getuUsername () == null || person.getuPassword () == null) {
            return Result.fail ("用户名或密码为空");
        }
        BUser xUser = userService.findUserByUserName (person);
        UsernamePasswordToken token = new UsernamePasswordToken (person.getuUsername (), person.getuPassword ());
        try {
            subject.login (token);
            BUser myNum = userService.getMyNum (xUser);
            xUser.setCarNum (myNum.getCarNum ());
            xUser.setCollectionNum (myNum.getCollectionNum ());
            xUser.setOrderNum (myNum.getOrderNum ());
            request.getSession ().setAttribute ("USERINFO", xUser);
            return Result.success ();
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            return Result.fail ("用户名或密码错误");
        }
    }

    @RequestMapping("/loginout")
    public String loginout(BUser person, HttpServletRequest request) {
        request.getSession ().removeAttribute ("USERINFO");
        request.getSession ().removeAttribute ("typeList");
        return "index";
    }

    @ResponseBody
    @RequestMapping("/register")
    public Result register(BUser person, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject ();
        //1.验证参数
        if (person.getuUsername () == null || person.getuPassword () == null) {
            return Result.fail ("用户名或密码为空");
        }
        BUser xUser = userService.findUserByUserName (person);
        if (xUser != null){
            return Result.fail ("用户名重复");
        }
        userService.register (person);
        return Result.success ("注册成功");
    }
}
