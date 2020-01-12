package com.zhaoshy.yomi.controller;

import com.zhaoshy.yomi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/****************************************
 * @author : zhaoshy
 * @description : 
 * @create_time : 2020/1/11 17:30
 ****************************************
 */

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getUserById")
    public String getUserById(Integer id) {
        return userService.getUserById(id);
    }
    @GetMapping("/deleteUserById")
    public void deleteUserById(Integer id) {
        userService.deleteUserById(id);
    }
}
