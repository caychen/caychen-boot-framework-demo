package com.caychen.boot.rabbitmq.demo.controller;

import com.caychen.boot.common.response.R;
import com.caychen.boot.rabbitmq.properties.RabbitQueueProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Caychen
 * @Date: 2024/2/6 17:39
 * @Description:
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    private RabbitQueueProperties properties;

    @GetMapping("/test")
    public R test() {
        List<RabbitQueueProperties.ExchangeConfig> exchanges = properties.getExchanges();
        return R.ok(exchanges);
    }
}
