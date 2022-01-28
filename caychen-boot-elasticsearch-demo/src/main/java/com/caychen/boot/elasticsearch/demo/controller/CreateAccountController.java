package com.caychen.boot.elasticsearch.demo.controller;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.caychen.boot.elasticsearch.demo.entity.Account;
import com.caychen.boot.elasticsearch.utils.EsUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @Author: Caychen
 * @Date: 2021/9/27 15:44
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/v1/account")
public class CreateAccountController {

    @Autowired
    private EsUtil esUtil;

    @GetMapping("/create")
    public String createAccount(int count) {
        String[] cities = {"北京市", "上海市", "南京市", "苏州市", "杭州市", "深圳市", "广州市", "无锡市", "南通市", "宁波市", "扬州市", "宿迁市", "常州市", "徐州市"};
        Random ageRandom = new Random(System.currentTimeMillis());
        Random genderRandom = new Random(System.currentTimeMillis());
        Random balanceRandom = new Random(System.currentTimeMillis());
        Random cityRandom = new Random(System.currentTimeMillis());
        StopWatch stopWatch = new StopWatch();
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);

        stopWatch.start("insert ...");
        for (int i = 0; i < count; i++) {
            long id = snowflake.nextId();
            try {
                Account account = new Account();
                account.setId(id);
                account.setGender(genderRandom.nextInt(1) == 0 ? "M" : "F");
                account.setAge(ageRandom.nextInt(50) + 10);
                account.setName(RandomStringUtils.random(10, "abcdefg"));
                account.setCity(cities[cityRandom.nextInt(cities.length)]);
                account.setBalance(new BigDecimal(balanceRandom.nextInt(100000) + 10000 + ""));

                Boolean result = esUtil.createData("account", id + "", account);
                log.info("新增结果：[{}]", result);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        stopWatch.stop();
        stopWatch.prettyPrint();

        return "success";
    }
}
