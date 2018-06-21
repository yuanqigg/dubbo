package com.accenture.services.manage;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisUseTest {

    public static void main(String [] args){
        Jedis jedis = new Jedis("127.0.0.1");

        System.out.println("连接成功");
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
        System.out.println("redis 存储的字符串为: "+ jedis.get("userinfo"));
    }
}
