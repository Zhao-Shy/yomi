package com.zhaoshy.yomi.config.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/****************************************
 * @author : zhaoshy
 * @description : 
 * @create_time : 2019/12/8 15:43
 ****************************************
 */

@Component
@Order(1)
public class MyCommandLineRunner1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("runner1 >>>>>>" + Arrays.toString(args));
    }
}
