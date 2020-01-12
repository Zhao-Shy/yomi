package com.zhaoshy.yomi.config;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/****************************************
 * @author : zhaoshy
 * @description : 
 * @create_time : 2020/1/11 16:36
 ****************************************
 */

@WebListener
public class MyListener implements ServletRequestListener
{
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("MyListener >>>>>> requestDestroyed");
    }
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("MyListener >>>>>> requestInitialized");
    }
}
