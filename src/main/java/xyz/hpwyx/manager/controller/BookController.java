package xyz.hpwyx.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.hpwyx.manager.pojo.BBook;
import xyz.hpwyx.manager.service.impl.BookServiceImpl;

@Controller
public class BookController {
    @Autowired
    private BookServiceImpl bookService;
    @RequestMapping(value = "addGood")
    public String addGood(BBook bBook) {

        bookService.addGood (bBook);
        return "redirect:/adminGood";
    }
    @RequestMapping(value = "delGood")
    public String delGood(BBook bBook) {

        bookService.delGood (bBook);
        return "redirect:/adminGood";
    }

    @RequestMapping(value = "updateGood")
    public String updateGood(BBook bBook) {

        bookService.updateGood (bBook);
        return "redirect:/adminGood";
    }
}
