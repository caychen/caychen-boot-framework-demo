package com.caychen.canal.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Caychen
 * @Date: 2022/1/28 17:35
 * @Description:
 */
@SpringBootApplication(scanBasePackages = {"com.caychen.canal.demo", "com.caychen.boot.canal"})
public class CanalDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CanalDemoApplication.class, args);
    }
}
