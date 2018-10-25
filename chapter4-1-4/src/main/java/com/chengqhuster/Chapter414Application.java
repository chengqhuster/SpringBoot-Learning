package com.chengqhuster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
public class Chapter414Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter414Application.class, args);
    }

    @Configuration
    @EnableAsync
    class TaskPoolConfig {

        @Bean
        public Executor taskExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(5);
            executor.setMaxPoolSize(20);
            executor.setThreadNamePrefix("taskExecutor-");
//            线程池关闭的时候等待所有任务都完成再继续销毁其他的Beans
            executor.setWaitForTasksToCompleteOnShutdown(true);
            executor.setAwaitTerminationSeconds(60);

            return executor;
        }
    }
}
