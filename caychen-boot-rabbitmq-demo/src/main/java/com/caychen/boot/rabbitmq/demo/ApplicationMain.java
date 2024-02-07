package com.caychen.boot.rabbitmq.demo;

import com.caychen.boot.rabbitmq.annotation.EnableRabbitProducer;
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
@EnableRabbitProducer
public class ApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }
}
