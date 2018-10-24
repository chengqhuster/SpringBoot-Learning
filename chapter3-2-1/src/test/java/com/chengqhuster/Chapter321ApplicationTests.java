package com.chengqhuster;

import com.chengqhuster.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Chapter321Application.class)
public class Chapter321ApplicationTests {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
        userService.deleteAllUsers();
    }

    @Test
    public void test() {
        // 插入5个用户
        userService.create("a", 1);
        userService.create("b", 2);
        userService.create("c", 3);
        userService.create("d", 4);
        userService.create("e", 5);

        // 查数据库，应该有5个用户
        Assert.assertEquals(5, userService.getAllUsers().intValue());

        // 删除两个用户
        userService.deleteByName("a");
        userService.deleteByName("e");

        // 查数据库，应该有3个用户
        Assert.assertEquals(3, userService.getAllUsers().intValue());
    }

}
