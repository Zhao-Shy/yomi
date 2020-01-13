package com.zhaoshy.yomi.service;

import com.zhaoshy.yomi.entity.Book;
import com.zhaoshy.yomi.mapper1.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : zhaoshy
 * @description  :
 * @create_time : 2019/12/8 15:43
 *
 **/

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public int addBook(Book book) {
        int i = bookMapper.addBook(book);
        return i;
    }
    public int deleteBookById(Integer id) {
        int i = bookMapper.deleteBookById(id);
        return i;
    }
    public int updateBookById(Book book) {
        int i = bookMapper.updateBookById(book);
        return i;
    }
    public Book getBookById(Integer id) {
        Book book = bookMapper.getBookById(id);
        return book;
    }
    public List<Book> getAllBooks() {
        List<Book> books = bookMapper.getAllBooks();
        return books;
    }
}
