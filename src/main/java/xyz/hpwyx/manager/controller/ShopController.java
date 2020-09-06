package xyz.hpwyx.manager.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.hpwyx.manager.pojo.BBook;
import xyz.hpwyx.manager.service.impl.BookServiceImpl;

import java.util.Arrays;
import java.util.List;


@Controller
public class ShopController {

    @Autowired
    private BookServiceImpl bookService;
    @RequestMapping(value = "toShop/{bTypeId}/{pageNum}")
    public String toShop(BBook bBook, @PathVariable Integer bTypeId,@PathVariable(required = false) Integer pageNum, Model model) {
        bBook.setbTypeId (bTypeId);
        if (pageNum == null){
            pageNum = 1;
        }
        bBook.setPageNum (pageNum);
        PageInfo<BBook> pageInfo = bookService.findBookByType (bBook);
        model.addAttribute ("type",bBook.getbTypeId ());
        model.addAttribute ("page",pageInfo);
        model.addAttribute ("pageNum",bBook.getPageNum ());
        return "shop";
    }

    @RequestMapping(value = "toBookInfo/{bookId}")
    public String toBookInfo(@PathVariable Integer bookId, Model model) {
        BBook bBook = bookService.get (bookId);
        String[] split = bBook.getbPic ().split ("\\|");
        List<String> picList = Arrays.asList (split);
        bBook.setPicList (picList);
        model.addAttribute ("book",bBook);
        return "bookInfo";
    }
}
