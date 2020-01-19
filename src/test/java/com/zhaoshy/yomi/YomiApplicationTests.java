package com.zhaoshy.yomi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhaoshy.yomi.entity.Book;
import com.zhaoshy.yomi.service.UserService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;

@RunWith(SpringRunner.class)
@SpringBootTest
class YomiApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    WebApplicationContext webApplicationContext;
    MockMvc mockMvc;
    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void test1() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/hello")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("name", "张三"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    @Test
    public void test2() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Book book = new Book();
        book.setAuthor("罗贯中");
        book.setName("三国演义");
        book.setId(1);
        String s = objectMapper.writeValueAsString(book);
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/book")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(s))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    @Test
    void contextLoads() {
        String result = userService.getUserById(1);
        Assert.assertThat(result, Matchers.is("delete..."));
    }
}
