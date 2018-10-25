package com.chengqhuster;

import com.chengqhuster.asyns.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Chapter412Application.class)
public class Chapter412ApplicationTests {

    @Autowired
    private Task task;

    @Test
    public void test() throws Exception{

        long start = System.currentTimeMillis();

        Future<String> result1 =  task.doTaskOne();
        Future<String> result2 = task.doTaskTwo();
        Future<String> result3 = task.doTaskThree();

        while (true) {
            if (result1.isDone() && result2.isDone() && result3.isDone()) {
                break;
            }
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

}
