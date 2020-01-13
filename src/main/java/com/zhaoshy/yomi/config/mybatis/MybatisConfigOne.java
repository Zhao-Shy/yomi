package com.zhaoshy.yomi.config.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/**
 * @author : zhaoshy
 * @description : 配置多数据源
 * @create_time : 2019/12/8 15:43
 **/

@Configuration
@MapperScan(value = "com.zhaoshy.yomi.mapper1", sqlSessionFactoryRef = "sqlSessionFactoryBean1")
public class MybatisConfigOne {
    @Autowired
    @Qualifier("dsOne")
    private DataSource dsOne;
    @Bean
    SqlSessionFactory sqlSessionFactoryBean1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dsOne);
        return factoryBean.getObject();
    }
    @Bean
    SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBean1());
    }
}
