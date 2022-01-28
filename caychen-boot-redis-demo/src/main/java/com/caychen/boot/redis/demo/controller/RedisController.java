package com.caychen.boot.redis.demo.controller;

import com.caychen.boot.common.response.R;
import com.caychen.boot.common.utils.UUIDUtil;
import com.caychen.boot.redis.component.RedisComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Caychen
 * @Date: 2021/8/28 10:15
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/v1/redis")
public class RedisController {

    @Autowired
    private RedisComponent redisComponent;

    @GetMapping("/set")
    public R<String> setValue(String key, String value) {
        redisComponent.set(key, value);
        return R.ok();
    }

    @GetMapping("/get")
    public R<String> getValue(String key) {
        return R.ok(redisComponent.get(key));
    }

    @GetMapping("/exist")
    public R<Boolean> isExists(String key) {
        return R.ok(redisComponent.isExists(key));
    }

    @GetMapping("/setWithExpire")
    public R<Boolean> setWithExpire(String key, String value, Long expire) {
        redisComponent.setWithExpire(key, value, expire, TimeUnit.SECONDS);
        return R.ok();
    }

    @GetMapping("/ttl")
    public R<Boolean> ttl(String key) {
        return R.ok(redisComponent.ttl(key));
    }

    @GetMapping("/lock")
    public R lock(String key) {
        String lockKey = key + "-Lock";
        String uuid = UUIDUtil.getUUIDWithReplaceBySpace();
        log.info("uuid：[{}]", uuid);

        try {
            Boolean lock = redisComponent.lock(lockKey, uuid, 100L, TimeUnit.SECONDS);
            if (lock) {
                log.info("获取到锁...");
                Thread.sleep(50000);
            } else {
                log.warn("未获取到锁...");
            }
        } catch (Exception e) {
            log.error("捕获异常...");
        } finally {
            Boolean unlockFlag = redisComponent.unlockByLua(lockKey, uuid);
            log.info("解锁：[{}]", unlockFlag);
            return R.ok(unlockFlag);
        }

    }

}
