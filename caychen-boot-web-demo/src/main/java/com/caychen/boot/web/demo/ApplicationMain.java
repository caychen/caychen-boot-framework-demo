package com.caychen.boot.web.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: Caychen
 * @Date: 2021/9/23 17:04
 * @Description:
 */
@SpringBootApplication
@ComponentScan({"com.caychen.boot"})
public class ApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }
}
