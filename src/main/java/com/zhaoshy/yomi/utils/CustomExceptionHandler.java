package com.zhaoshy.yomi.utils;

import org.apache.catalina.filters.WebdavFixFilter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.PushbackInputStream;
import java.util.HashMap;
import java.util.Map;

/****************************************
 * @author : zhaoshy
 * @description : 
 * @create_time : 2020/1/7 22:38
 ****************************************
 */

@ControllerAdvice
public class CustomExceptionHandler {
    /**
     * @author : zhaoshy
     * @parameter : [e, response]
     * @return : void
     * @description : 全局异常处理
     * @create_time : 2020/1/7
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public void uploadException(MaxUploadSizeExceededException e, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("上传文件超过限制");
        out.flush();
        out.close();
    }

    /**
     * @author : zhaoshy
     * @parameter : []
     * @return : java.util.Map<java.lang.String,java.lang.String>
     * @description : 添加全局数据
     * @create_time : 2020/1/7
     */
    @ModelAttribute(value = "info")
    public Map<String, String> userInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("username", "赵舜禹");
        map.put("gender", "男");
        return map;
    }

    /**
     * @author : zhaoshy
     * @parameter : [binder]
     * @return : void
     * @description : 请求参数预处理
     * @create_time : 2020/1/7
     */
    @InitBinder("book")
    public void preProcessing2Book(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("book.");
    }
    @InitBinder("author")
    public void preProcessing2Author(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("author.");
    }
}
