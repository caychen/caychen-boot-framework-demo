package com.caychen.boot.rabbitmq.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Caychen
 * @Date: 2024/2/6 17:57
 * @Description:
 */
@Slf4j
@Configuration
public class CustomRabbitCallbackConfig {

    @Bean
    public RabbitTemplate.ReturnCallback returnCallback() {
        log.info("============> 注册自定义的returnCallback");
        return (message, replyCode, replyText, exchange, routingKey) -> {
            log.error("returnCallback");
        };
    }

    @Bean
    public RabbitTemplate.ConfirmCallback confirmCallback() {
        log.info("============> 注册自定义的confirmCallback");
        return (correlationData, ack, cause) -> {
            log.error("confirmCallback");
        };
    }
}
