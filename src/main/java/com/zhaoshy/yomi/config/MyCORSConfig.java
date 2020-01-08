package com.zhaoshy.yomi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/****************************************
 * @author : zhaoshy
 * @description : 全局配置 CORS
 * @create_time : 2019/12/8 15:43
 ****************************************
 */

@Configuration
public class MyCORSConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/book/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOrigins("http://localhost:8081");
    }
}
