package com.huang.serviceimpl;

import com.huang.Hello;
import com.huang.HelloService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Huang RD
 * @date 2023/4/26 19:02
 * @description
 */
@Slf4j
public class HelloServiceImpl2 implements HelloService {

    static {
        System.out.println("HelloServiceImpl2被创建");
    }

    @Override
    public String hello(Hello hello) {
        log.info("HelloServiceImpl2收到: {}.", hello.getMessage());
        String result = "Hello description is " + hello.getDescription();
        log.info("HelloServiceImpl2返回: {}.", result);
        return result;
    }

}
