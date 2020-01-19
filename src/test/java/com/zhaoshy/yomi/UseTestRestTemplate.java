package com.zhaoshy.yomi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/****************************************
 * @author : zhaoshy
 * @description : 
 * @create_time : 2020/1/18 22:11
 ****************************************
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UseTestRestTemplate {
    @Autowired
    TestRestTemplate template;
    @Test
    public void test3() {
        ResponseEntity<String> hello = template.getForEntity("/hello?name={0}", String.class, "张三");
        System.out.println(hello.getBody());
    }
}
