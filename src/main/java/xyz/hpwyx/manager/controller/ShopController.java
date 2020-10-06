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
        //如果没有传页数，默认第一页
        if (pageNum == null){
            pageNum = 1;
        }
        bBook.setPageNum (pageNum);
        PageInfo<BBook> pageInfo = bookService.findBookByType (bBook);
        model.addAttribute ("type",bBook.getbTypeId ());
        //如果该分类下有商品
        if (pageInfo.getList ().size () > 0){
            //则
            model.addAttribute ("typeName",pageInfo.getList ().get (0).getTypeName ());
        }
        model.addAttribute ("page",pageInfo);
        model.addAttribute ("pageNum",bBook.getPageNum ());
        return "shop";
    }

    /**
     * 搜索方法
     */
    @RequestMapping(value = "searchBook")
    public String searchBook(BBook bBook, String key,Integer pageNum, Model model) {
        //如果没有传页数，默认第一页
        if (pageNum == null){
            pageNum = 1;
        }
        bBook.setPageNum (pageNum);
        bBook.setbName (key);
        PageInfo<BBook> pageInfo = bookService.findBookByType (bBook);
        //如果该分类下有商品
        if (pageInfo.getList ().size () > 0){
            //则
            model.addAttribute ("typeName",pageInfo.getList ().get (0).getTypeName ());
        }
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
        //推荐书籍
        BBook bBook1 = new BBook ();
        bBook1.setbTypeId (bBook.getbTypeId ());
        bBook1.setLimit (4);
        List<BBook> bookList = bookService.findBookList (bBook1);
        model.addAttribute ("recomBook",bookList);
        return "bookInfo";
    }

    /**
     * 排行 根据购买数量进行排行
     */
    @RequestMapping(value = "bookPaihang")
    public String bookPaihang(Model model) {
        List<BBook> listBySale = bookService.findListBySale ();
        model.addAttribute ("book",listBySale);
        return "paihang";
    }
}
