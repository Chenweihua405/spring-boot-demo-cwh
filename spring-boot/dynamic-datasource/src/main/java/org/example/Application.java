package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 陈卫华
 * @date 2024/11/25
 */
@SpringBootApplication
@MapperScan({ "org.example.mapper" })
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}