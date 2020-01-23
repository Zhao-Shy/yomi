package com.zhaoshy.yomi;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * @Author: zhaoshy
 * @License: (C) Copyright 2016-2999, xxx Corporation Limited.
 * @Contact: zsyfaith@163.com
 * @Date: 2020-01-23 18:10
 * @Version: 1.0
 * @Description: 使用 Redis 集群方法缓存
 */

@Repository
public class BookDao {
    @Cacheable(value = "c1")
    public String getBookById(Integer id) {
        System.out.println("getBookById");
        return "这本书是三国演义";
    }
    @CachePut(value = "c1")
    public String updateBookById(Integer id) {
        System.out.println("updateBookById");
        return "这是全新的三国演义";
    }
    @CacheEvict(value = "c1")
    public void deleteBookById(Integer id) {
        System.out.println("deleteBookById");
    }
    @Cacheable
    public String getBookById2(Integer id) {
        System.out.println("getBookById2");
        return "这本书是红楼梦";
    }
}
