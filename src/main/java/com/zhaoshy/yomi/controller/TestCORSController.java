package com.zhaoshy.yomi.controller;

import com.zhaoshy.yomi.entity.Book;
import org.springframework.web.bind.annotation.*;

/****************************************
 * @author : zhaoshy
 * @description : 细粒度配置 CORS 跨域请求
 * @create_time : 2019/12/8 15:43
 ****************************************
 */

@RestController
@RequestMapping("/book")
public class TestCORSController {
    @PostMapping("/add")
    @CrossOrigin(value = "http://localhost:8081", maxAge = 1800, allowedHeaders = "*")
    public String addBook() {
        Book book = new Book();
        book.setId(1);
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        return book.toString();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Integer id) {
        return "删除成功";
    }
}
