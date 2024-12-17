package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 陈卫华
 * @date 2024/11/25
 */
@SpringBootApplication
@MapperScan({"org.example.mapper"})
@ComponentScan({"org.example.*"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}