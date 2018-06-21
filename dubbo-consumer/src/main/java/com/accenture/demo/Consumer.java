package com.accenture.demo;

import com.accenture.dubbo.demo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml"});
        context.start();
        final DemoService demoService = (DemoService) context.getBean("demoQmxService");
        //测试
        String hello = demoService.sayHello("Tom");
        System.out.println(hello);
    }
}
