package com.caychen.boot.web.demo.controller;

import com.caychen.boot.common.response.PageVo;
import com.caychen.boot.common.response.R;
import com.caychen.boot.web.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Caychen
 * @Date: 2024/2/7 17:27
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    static List<User> userList = List.of(
            new User(1L, "caychen"),
            new User(2L, "caychen2"),
            new User(3L, "caychen3"),
            new User(4L, "tom")
    );

    @GetMapping("/query")
    public R queryUserList(User user) {
        List<User> userStream = userList.stream().filter(u -> u.getName().contains("caychen")).skip(1).limit(2).collect(Collectors.toList());

        PageVo pageVo = new PageVo();
        pageVo.setData(userStream);
        pageVo.setPageIndex(1);
        pageVo.setPageSize(2);
        pageVo.setTotal(3);

        return R.ok(pageVo);
    }

    @GetMapping("/query/{id}")
    public R queryUserList(@PathVariable("id") Long id) {
        User user = userList.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
        log.info("查询到用户信息：{}", user);
        return R.ok(user);
    }
}
