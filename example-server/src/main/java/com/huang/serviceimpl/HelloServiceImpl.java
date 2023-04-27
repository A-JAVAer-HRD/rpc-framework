package com.huang.serviceimpl;

import com.huang.Hello;
import com.huang.HelloService;
import com.huang.annotation.RpcService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Huang RD
 * @date 2023/4/26 19:03
 * @description
 */
@Slf4j
@RpcService(group = "test1", version = "version1")
public class HelloServiceImpl implements HelloService {

    static {
        System.out.println("HelloServiceImpl被创建");
    }

    @Override
    public String hello(Hello hello) {
        log.info("HelloServiceImpl收到: {}.", hello.getMessage());
        String result = "Hello description is " + hello.getDescription();
        log.info("HelloServiceImpl返回: {}.", result);
        return result;
    }

}
