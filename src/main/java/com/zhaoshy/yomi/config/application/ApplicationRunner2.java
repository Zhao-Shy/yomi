package com.zhaoshy.yomi.config.application;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/****************************************
 * @author : zhaoshy
 * @description : 
 * @create_time : 2019/12/8 15:43
 ****************************************
 */

@Component
@Order(2)
public class ApplicationRunner2 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> nonOptionArgs = args.getNonOptionArgs();
        System.out.println("2-nonOptionArgs >>>>>> " + nonOptionArgs);
        Set<String> optionNames = args.getOptionNames();
        for (String optionName : optionNames) {
            System.out.println("2-key: " + optionName + "; value: " + args.getOptionValues(optionName));
        }
    }
}
