package com.caychen.boot.admin.client.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: Caychen
 * @Date: 2021/8/27 17:41
 * @Description:
 */
@SpringBootApplication
@ComponentScan({"com.caychen.boot"})
public class AdminClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminClientDemoApplication.class, args);
    }
}
