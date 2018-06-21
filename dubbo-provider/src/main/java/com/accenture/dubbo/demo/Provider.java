package com.accenture.dubbo.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.lang.System.*;

public class Provider {

     public static void main(String[] args) throws Exception{
         ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                 new String[] { "applicationContext.xml" });
         context.start();
         System.out.println("启动成功");
         System.in.read(); // 为保证服务一直开
     }
}
