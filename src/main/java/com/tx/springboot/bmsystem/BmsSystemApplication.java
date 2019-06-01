package com.tx.springboot.bmsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * 图书管理系统
 *
 * @author tx
 * @ComponentScan("com.tx.springboot.*")用来扫描装配好的Bean
 * @date 2019/03/22
 */
@SpringBootApplication
@ComponentScan("com.tx.springboot.bmsystem.*")
@MapperScan(basePackages= {"com.tx.springboot.bmsystem.dao"})
public class BmsSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmsSystemApplication.class, args);
    }

}
