package com.zhaoshy.yomi.service;

import org.springframework.stereotype.Service;

/****************************************
 * @author : zhaoshy
 * @description : 
 * @create_time : 2020/1/11 17:08
 ****************************************
 */

@Service
public class UserService {
    public String getUserById(Integer id) {
        System.out.println("get...");
        return "user";
    }
    public void deleteUserById(Integer id) {
        System.out.println("delete...");
    }
}
