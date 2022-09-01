package com.caychen.boot.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Caychen
 * @Date: 2022/9/1 11:07
 * @Description:
 */
@Data
public class Person {

    private Long id;

    private String name;

    private String address;

    private Integer age;

    private Date createTime;

}
