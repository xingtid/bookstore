package xyz.hpwyx.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.hpwyx.manager.pojo.BBookType;
import xyz.hpwyx.manager.service.impl.BookTypeServiceImpl;


@Controller
public class BookTypeController {
    @Autowired
    private BookTypeServiceImpl bookTypeService;

    @RequestMapping(value = "addType")
    public String addType(BBookType type) {

        bookTypeService.addType (type);
        return "redirect:/adminType";
    }
    @RequestMapping(value = "delType")
    public String delType(BBookType type) {

        bookTypeService.delType (type);
        return "redirect:/adminType";
    }

    @RequestMapping(value = "updateType")
    public String updateType(BBookType type) {

        bookTypeService.updateType (type);
        return "redirect:/adminType";
    }
}
