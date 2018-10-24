package com.chengqhuster;

import com.chengqhuster.domain.User;
import com.chengqhuster.domain.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Chapter327Application.class)
@Transactional
public class Chapter327ApplicationTests {

    // UserMapper是个接口，spring启动后会有相关的实现bean，可以扫描到
    // 这里加上(required = false)是为了去掉intelliJ的报错
    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    @Rollback
    public void test() {
        userMapper.insert("eee", 20);
        User u = userMapper.findByName("eee");
        Assert.assertEquals(20, u.getAge().intValue());
    }

    @Test
    public void resultMapTest() {
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            Assert.assertEquals(null, user.getId());
            Assert.assertNotEquals(null, user.getName());
            System.out.println("User info[name : " + user.getName() + ", age : " + user.getAge() + "]");
        }
    }
}
