package com.caychen.boot.common.entity;

import com.caychen.boot.common.config.deserializer.DateDeserializer;
import com.caychen.boot.common.config.serializer.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: Caychen
 * @Date: 2021/8/28 14:30
 * @Description:
 */
@Data
@ToString(exclude = {"id"})
public class User {

    private Long id;

    private String name;

    @JsonDeserialize(using = DateDeserializer.class)
    @JsonSerialize(using = DateSerializer.class)
    private Date birth;
}
