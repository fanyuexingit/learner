package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//如果结构不是标准结构，或者有些包在主类之外，用扫包注解扫进来，也可用@Bean把每个类都加载进来
//@ComponentScan(basePackages="com.example")
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
