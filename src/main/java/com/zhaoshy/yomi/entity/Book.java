package com.zhaoshy.yomi.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/****************************************
 * @author : zhaoshy
 * @description : 
 * @create_time : 2019/12/8 15:43
 ****************************************
 */

@Data
@Component
@ConfigurationProperties(prefix = "book")
public class Book {
    private String name;
    private String author;
    private float price;
}
