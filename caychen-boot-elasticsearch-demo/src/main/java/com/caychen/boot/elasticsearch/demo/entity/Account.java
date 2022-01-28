package com.caychen.boot.elasticsearch.demo.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: Caychen
 * @Date: 2021/9/27 15:40
 * @Description:
 */
@Data
public class Account {

    private Long id;

    private String name;

    private String gender;

    private Integer age;

    private String city;

    private BigDecimal balance;
}
