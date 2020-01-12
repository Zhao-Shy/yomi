package com.zhaoshy.yomi.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/****************************************
 * @author : zhaoshy
 * @description : 配置 AOP
 * @create_time : 2020/1/11 17:09
 ****************************************
 */

@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* com.zhaoshy.yomi.service.*.*(..))")
    public void pcl() {
    }
    @Before(value = "pcl()")
    public void before(JoinPoint joinPoint) {
         String name = joinPoint.getSignature().getName();
         System.out.println(name + "方法开始执行...");
    }
    @After(value = "pcl()")
    private void after(JoinPoint joinPoint) {
         String name = joinPoint.getSignature().getName();
         System.out.println(name + "方法开始结束...");
    }
    @AfterReturning(value = "pcl()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
         String name = joinPoint.getSignature().getName();
         System.out.println(name + "方法返回值为: " + result);
    }
    @AfterThrowing(value = "pcl()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
         String name = joinPoint.getSignature().getName();
         System.out.println(name + "方法抛异常了, 异常是: " + e.getMessage());
    }
    @Around("pcl()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
         return proceedingJoinPoint.proceed();
    }
}
