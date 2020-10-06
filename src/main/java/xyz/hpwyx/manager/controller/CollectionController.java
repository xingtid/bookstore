package xyz.hpwyx.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.hpwyx.manager.common.Result;
import xyz.hpwyx.manager.pojo.BBook;
import xyz.hpwyx.manager.pojo.BCollection;
import xyz.hpwyx.manager.pojo.BUser;
import xyz.hpwyx.manager.service.impl.BookServiceImpl;
import xyz.hpwyx.manager.service.impl.CollectionServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CollectionController {
    @Autowired
    private CollectionServiceImpl collectionService;
    @Autowired
    private BookServiceImpl bookService;
    @ResponseBody
    @RequestMapping("/addCollection/{bookId}")
    public Result addCollection(@PathVariable Integer bookId, HttpServletRequest request) {
        BUser userinfo = (BUser) request.getSession ().getAttribute ("USERINFO");
        if (userinfo == null){
            return Result.fail ("请先登录");
        }
        BCollection collection = new BCollection ();
        collection.setcBookId (bookId);
        collection.setcUserId (userinfo.getuId ());
        collection.setcDate (new Date ());
        collectionService.addCollection (collection);
        return Result.success ();
    }
    @RequestMapping("/getMyCollection")
    public String getMyCollection(HttpServletRequest request, Model model) {
        BUser userinfo = (BUser) request.getSession ().getAttribute ("USERINFO");
        if (userinfo == null){
            return "login";
        }
        BCollection collection = new BCollection ();
        collection.setcUserId (userinfo.getuId ());
        List<BCollection> myCollection = collectionService.getMyCollection (collection);
        List<BBook> bBooks = new ArrayList<> ();
        for (BCollection item : myCollection) {
            BBook bBook = bookService.get (item.getcBookId ());
            bBooks.add (bBook);
        }
        model.addAttribute ("collectionList",bBooks);
        return "userCollection";
    }
}
