package com.zhaoshy.yomi.mapper1;

import com.zhaoshy.yomi.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/****************************************
 * @author : zhaoshy
 * @description : 
 * @create_time : 2020/1/12 12:26
 ****************************************
 */

public interface BookMapper {
    int addBook(Book book);
    int deleteBookById(Integer id);
    int updateBookById(Book book);
    Book getBookById(Integer id);
    List<Book> getAllBooks();
}
