package com.chengqhuster;

import com.chengqhuster.asyns.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Chapter413Application.class)
public class Chapter413ApplicationTests {

    @Autowired
    private Task task;

    @Test
    public void test() throws Exception{

        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();

        Thread.currentThread().join();
    }

}
