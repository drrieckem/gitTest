package com.example.lvbackend;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//通过注解取消该类的启动
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan("com.example")
@MapperScan("com.example.mapper")
//通过axios 或者ajax 来通过前端请求后台的数据
public class LvBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LvBackendApplication.class, args);
    }

}
