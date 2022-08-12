package com.hxw.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author HuShengHenGao
 * @Date 2022/8/13
 **/
@SpringBootApplication
public class AppSpringApplication {
    public static void main(String[] args){
        SpringApplication application = new SpringApplication();
        application.run(AppSpringApplication.class, args);
    }
}
