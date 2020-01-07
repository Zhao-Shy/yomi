package com.zhaoshy.yomi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/****************************************
 * @author : zhaoshy
 * @description : 
 * @create_time : 2020/1/7 21:36
 ****************************************
 */

@Controller
public class ErrorController {
    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/uploadFile")
    public String uploadHtml() {
        return "upload";
    }
}
