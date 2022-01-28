package com.caychen.boot.jwt.demo;

import com.caychen.boot.jwt.utils.JwtUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Caychen
 * @Date: 2021/9/23 17:04
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Map<String, Object> payload = new HashMap<>() {{
            put("userid", "122222");
            put("age", 20);
            put("now", new Date());
        }};
        String jwt = JwtUtil.createJWT(payload, null, "key", "caychen", 3600000L);
        System.out.println(jwt);
    }
}
