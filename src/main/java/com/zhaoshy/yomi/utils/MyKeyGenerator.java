package com.zhaoshy.yomi.utils;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/****************************************
 * @author : zhaoshy
 * @description : 
 * @create_time : 2020/1/19 14:50
 ****************************************
 */

@Component
public class MyKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) {
        return Arrays.toString(params);
    }
}
