package com.accenture.dubbo.demo;
import com.accenture.dubbo.demo.DemoService;

public class DemoServiceImpl implements DemoService {

    public String sayHello(String name){
        return "Hello " + name;
    }

}
