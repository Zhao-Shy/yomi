package com.zhaoshy.yomi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/****************************************
 * @author : zhaoshy
 * @description : 使用 xml 注册 bean
 * @create_time : 2019/12/8 15:43
 ****************************************
 */

@Configuration
@ImportResource("classpath:beans.xml")
public class BookConfig {
}
