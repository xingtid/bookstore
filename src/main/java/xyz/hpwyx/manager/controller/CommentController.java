package xyz.hpwyx.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.hpwyx.manager.common.Result;
import xyz.hpwyx.manager.pojo.BComment;
import xyz.hpwyx.manager.pojo.BUser;
import xyz.hpwyx.manager.service.CommentService;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    @RequestMapping("/addComment")
    @ResponseBody
    public Result addComment(BComment comment, HttpSession session) {
        comment.setTime (new Date ());
        BUser userinfo = (BUser) session.getAttribute ("USERINFO");
        if (userinfo == null) {
            return Result.fail ("请先登录");
        }
        comment.setUserId (userinfo.getuId ());
        commentService.addComment (comment);
        return Result.success ();
    }
}
