package com.chengqhuster;

import com.chengqhuster.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Chapter325Application.class)
public class Chapter325ApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Test
    public void test() {

        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void serializeTest() {

        // 保存对象
        User user = new User("superMan", 20);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        user = new User("batMan", 30);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        user = new User("spiderMan", 40);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        Assert.assertEquals(20, redisTemplate.opsForValue().get("superMan").getAge().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("batMan").getAge().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("spiderMan").getAge().longValue());
    }
}
