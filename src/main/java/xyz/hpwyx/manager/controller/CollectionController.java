package xyz.hpwyx.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.hpwyx.manager.pojo.BCollection;
import xyz.hpwyx.manager.pojo.BUser;
import xyz.hpwyx.manager.service.impl.CollectionServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class CollectionController {
    @Autowired
    private CollectionServiceImpl collectionService;

    @ResponseBody
    @RequestMapping("/addCollection/{bookId}")
    public void addCollection(@PathVariable Integer bookId, HttpServletRequest request) {
        BUser userinfo = (BUser) request.getSession ().getAttribute ("USERINFO");
        BCollection collection = new BCollection ();
        collection.setcBookId (bookId);
        collection.setcUserId (userinfo.getuId ());
        collection.setcDate (new Date ());
        collectionService.addCollection (collection);
    }
}
