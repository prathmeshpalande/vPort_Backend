package com.virtual.portable.server;

import java.sql.Time;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.virtual.portable.server.service.ScreenGrabService;
import com.virtual.portable.server.task.ScreenGrabTask;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.virtual.portable.server")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

//        ScreenGrabTask screenGrabTask = new ScreenGrabTask();
//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
//        executorService.schedule(screenGrabTask, 1, TimeUnit.MILLISECONDS);
//
//        try {
//            executorService.awaitTermination(1, TimeUnit.DAYS);
//        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        new ScreenGrabTask().start();
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}
