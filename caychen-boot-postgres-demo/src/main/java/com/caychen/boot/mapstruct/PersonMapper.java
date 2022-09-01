package com.caychen.boot.mapstruct;

import com.caychen.boot.controller.vo.request.PersonRequest;
import com.caychen.boot.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author: Caychen
 * @Date: 2022/9/1 11:43
 * @Description:
 */
@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person convertToUser(PersonRequest request);
}
