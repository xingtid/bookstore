package xyz.hpwyx.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.hpwyx.manager.pojo.BBook;
import xyz.hpwyx.manager.pojo.BBookType;
import xyz.hpwyx.manager.service.BookService;
import xyz.hpwyx.manager.service.BookTypeService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author tid
 * @create 2019-03-16 15:02
 **/
@Controller
public class IndexController {
    @Autowired
    private BookTypeService bookTypeService;
    @Autowired
    private BookService bookService;

    @RequestMapping(value = {"/","index.html"})
    public String index(Model model, HttpServletRequest request) {
        List<BBookType> allType = bookTypeService.findAllType ();
        request.getSession ().setAttribute ("typeList", allType);
        List<BBook> bookList = bookService.findBookList ();
        model.addAttribute ("bookList",bookList);
        return "index";
    }


    //  全局跳转
    @RequestMapping("/{page}.html")
    public String showPage2(@PathVariable String page, HttpServletRequest request, Model model) {
        String url = request.getHeader ("REFERER");
        System.out.println (url);
        List<BBookType> allType = bookTypeService.findAllType ();
        request.getSession ().setAttribute ("typeList", allType);
        model.addAttribute ("REFERER", url);
        return page;
    }
}
