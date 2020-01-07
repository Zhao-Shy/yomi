package com.zhaoshy.yomi.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

/****************************************
 * @author : zhaoshy
 * @description : 配置 http 重定向 https
 * @create_time : 2019/12/8 15:43
 ****************************************
 */

public class TomcatConfig {
    
    /***
     * @Author: ZhaoShy
     * @Date: 2020/1/7
     * @Param: []
     * @Return: org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
     * @Description: 配置 TomcatServletWebServerFactory, 添加 Tomcat 中的 Connector (监听8080端口), 并将请求转发到 8081
     */
    @Bean
    TomcatServletWebServerFactory factory () {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory(){
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };
        factory.addAdditionalTomcatConnectors(createTomcatConnector());
        return factory;
    }

    private Connector createTomcatConnector() {
        Connector connector = new Connector("org.apache.coyote.httpll.HttpllNioProtocol");
        connector.setScheme("http");
        connector.setPort(8080);
        connector.setSecure(false);
        connector.setRedirectPort(8081);
        return connector;
    }
}
