package com.caychen.boot;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 */
@EnableKnife4j
@SpringBootApplication
@MapperScan("com.caychen.boot.dao")
public class PostgresDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostgresDemoApplication.class, args);
    }
}
