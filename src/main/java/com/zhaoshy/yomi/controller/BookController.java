package com.zhaoshy.yomi.controller;

import com.zhaoshy.yomi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/****************************************
 * @author : zhaoshy
 * @description : 整合 mybatis
 * @create_time : 2019/12/8 15:43
 ****************************************
 */

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
}
