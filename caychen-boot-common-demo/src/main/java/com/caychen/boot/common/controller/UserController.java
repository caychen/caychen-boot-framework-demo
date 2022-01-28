package com.caychen.boot.common.controller;

import com.caychen.boot.common.entity.User;
import com.caychen.boot.common.response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: Caychen
 * @Date: 2021/8/28 14:32
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @GetMapping("/get")
    public R<User> getUser() {
        User user = new User();
        user.setId(1L);
        user.setName("caychen");
        user.setBirth(new Date());

        return R.ok(user);
    }

    @PostMapping("/set")
    public R<User> setUser(@RequestBody User user) {
        log.info("user: [{}]", user);
        return R.ok(user);
    }
}
