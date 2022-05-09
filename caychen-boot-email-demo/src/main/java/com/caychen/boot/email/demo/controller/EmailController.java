package com.caychen.boot.email.demo.controller;

import com.caychen.boot.common.response.R;
import com.caychen.boot.email.component.MailComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Caychen
 * @Date: 2022/5/9 21:13
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/v1/email")
public class EmailController {

    @Autowired
    private MailComponent mailComponent;

    @GetMapping("/sendSimpleEmail")
    public R sendSimple(String subject, String text) {
        mailComponent.sendSimpleMail(subject, text);

        return R.ok();
    }
}
