package com.zhaoshy.yomi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/****************************************
 * @author : zhaoshy
 * @description : 完全自定义错误页面及错误数据
 * @create_time : 2019/12/8 15:43
 ****************************************
 */

@Controller
public class MyErrorController extends BasicErrorController {
    //次数 @Autowired 是表示构造方法中的参数, 需要引入
    @Autowired
    public MyErrorController (ErrorAttributes errorAttributes, ServerProperties serverProperties,
                              List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, serverProperties.getError(), errorViewResolvers);
    }

    @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = getStatus(request);
        Map<String, Object> errorAttributes = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
        errorAttributes.put("custommsg", "出错啦");
        ModelAndView modelAndView = new ModelAndView("myErrorPage", errorAttributes, status);
        return modelAndView;
    }

    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> errorAttributes = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
        errorAttributes.put("custommsg", "出错啦");
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>(errorAttributes, status);
    }
}
