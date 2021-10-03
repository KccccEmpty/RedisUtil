package com.example.redisspringboot;

import com.example.redisspringboot.pojo.User;
import com.example.redisspringboot.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisSpringbootApplicationTests {

    @Autowired
    @Qualifier("myRedisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtils redisUtils;

    @Test
    void contextLoads() {
        //redisTemplate 操作不同的数据类型，和基本命令相同
        //opsForValue() 操作字符串 类似String
        //opsForList() 操作List 类似List
        //opsForHash()
        //opsForGeo()
        //....

        //除了基本的操作，常用的方法可以直接通过redisTemplate来操作，比如事务和基本的CRUD

        //获取redis的连接对象
        //RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        //connection.flushDb();
        //connection.flushAll();
        redisTemplate.opsForValue().set("key", "kc");
        System.out.println(redisTemplate.opsForValue().get("key"));
    }

    @Test
    void test() {
        User user = new User("kongcheng", 10);
        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    @Test
    void test2() {
        redisUtils.set("user", "kongcheng");
        System.out.println(redisUtils.get("user"));
    }

}
