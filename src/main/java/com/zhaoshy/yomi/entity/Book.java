package com.zhaoshy.yomi.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/****************************************
 * @author : zhaoshy
 * @description : 
 * @create_time : 2020/1/7 20:44
 ****************************************
 */

@Alias("book")
@Data
public class Book implements Serializable {
    private Integer id;
    private String name;
    private String author;
}
