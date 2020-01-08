package com.zhaoshy.yomi.utils;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/****************************************
 * @author : zhaoshy
 * @description : 自定义error数据
 * @create_time : 2019/12/8 15:43
 ****************************************
 */

@Component
public class CustomErrorPage extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("customMsg", "出错啦");
        errorAttributes.remove("error");
        return errorAttributes;
    }
}
