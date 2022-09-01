package com.caychen.boot.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caychen.boot.common.response.R;
import com.caychen.boot.controller.vo.request.PersonRequest;
import com.caychen.boot.entity.Person;
import com.caychen.boot.mapstruct.PersonMapper;
import com.caychen.boot.service.IPersonService;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @Author: Caychen
 * @Date: 2022/9/1 11:36
 * @Description:
 */
@Api(tags = "人员Api")
@RestController
@RequestMapping("/v1/person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @PostMapping
    public R insertPerson(@RequestBody PersonRequest personRequest) {
        Person person = PersonMapper.INSTANCE.convertToUser(personRequest);
        personService.save(person);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R updatePerson(@RequestBody PersonRequest personRequest, @PathVariable("id") Long id) {
        Person person = PersonMapper.INSTANCE.convertToUser(personRequest);
        person.setId(id);
        personService.updateById(person);
        return R.ok();
    }

    @PostMapping("/list")
    public R listPerson(@RequestBody PersonRequest personRequest) {
        LambdaQueryWrapper<Person> queryWrapper = new LambdaQueryWrapper(Person.class);
        if (StringUtils.isNotBlank(personRequest.getAddress())) {
            queryWrapper.like(Person::getAddress, personRequest.getAddress());
        }
        if (StringUtils.isNotBlank(personRequest.getName())) {
            queryWrapper.like(Person::getName, personRequest.getName());
        }
        if (Objects.nonNull(personRequest.getAge())) {
            queryWrapper.eq(Person::getAge, personRequest.getAge());
        }
        if (Objects.nonNull(personRequest.getId())) {
            queryWrapper.eq(Person::getId, personRequest.getId());
        }
        if (Objects.nonNull(personRequest.getCreateTime())) {
            queryWrapper.ge(Person::getCreateTime, personRequest.getCreateTime());
        }
        List<Person> list = personService.list(queryWrapper);
        return R.ok(list);
    }

    @PostMapping("/page")
    public R pagePerson(
            @RequestParam(required = false, defaultValue = "1") int pageIndex,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            PersonRequest personRequest) {
        LambdaQueryWrapper<Person> queryWrapper = new LambdaQueryWrapper(Person.class);
        if (StringUtils.isNotBlank(personRequest.getAddress())) {
            queryWrapper.like(Person::getAddress, personRequest.getAddress());
        }
        if (StringUtils.isNotBlank(personRequest.getName())) {
            queryWrapper.like(Person::getName, personRequest.getName());
        }
        if (Objects.nonNull(personRequest.getAge())) {
            queryWrapper.eq(Person::getAge, personRequest.getAge());
        }
        if (Objects.nonNull(personRequest.getId())) {
            queryWrapper.eq(Person::getId, personRequest.getId());
        }
        if (Objects.nonNull(personRequest.getCreateTime())) {
            queryWrapper.ge(Person::getCreateTime, personRequest.getCreateTime());
        }

        Page<Person> page = personService.page(new Page(pageIndex, pageSize), queryWrapper);
        return R.ok(page);
    }

    @DeleteMapping("/{id}")
    public R listPerson(@PathVariable Long id) {
        personService.removeById(id);
        return R.ok();
    }
}
