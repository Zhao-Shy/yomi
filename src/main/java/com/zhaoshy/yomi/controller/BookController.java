package com.zhaoshy.yomi.controller;

import com.zhaoshy.yomi.entity.Book;
import com.zhaoshy.yomi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @GetMapping("/redis")
    public void testRedis() {
        ValueOperations<String, String> ops1 = stringRedisTemplate.opsForValue();
        ops1.set("name", "三国演义");
        String name = ops1.get("name");
        System.out.println(name);

        ValueOperations ops2 = redisTemplate.opsForValue();
        Book book = new Book();
        book.setId(1);
        book.setName("红楼梦");
        book.setAuthor("曹雪芹");

        ops2.set("book", book);
        Book b = (Book) ops2.get("book");
        System.out.println(b);
    }
}
