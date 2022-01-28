package com.caychen.boot.elasticsearch.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: Caychen
 * @Date: 2021/9/27 15:38
 * @Description:
 */
@SpringBootApplication
@ComponentScan("com.caychen.boot")
public class ElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class,args);
    }
}
