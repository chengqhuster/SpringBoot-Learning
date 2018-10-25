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

        // 阻塞并等待当前线程结束（it will never happen）
        // 这里为了防止在观察其他线程状态时当前线程结束，项目代码中不要这种写法
        Thread.currentThread().join();
    }

}
