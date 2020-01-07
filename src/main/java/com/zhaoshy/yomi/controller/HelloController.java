package com.zhaoshy.yomi.controller;

import com.zhaoshy.yomi.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/****************************************
 * @author : zhaoshy
 * @description : 
 * @create_time : 2019/12/8 15:43
 ****************************************
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        if (0 > 1) {
            return "hello";
        }else {
            return "error";
        }
    }

    @Autowired
    private Book book;

    @RequestMapping("/book")
    public String getBook() {
        return book.toString();
    }
}