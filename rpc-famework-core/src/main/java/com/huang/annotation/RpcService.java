package com.huang.annotation;


import java.lang.annotation.*;

/**
 * RPC服务注解，标注在服务实现类上
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
public @interface RpcService {

    /**
     * 服务版本，默认为空串
     */
    String version() default "";

    /**
     * 服务组，默认为空串
     */
    String group() default "";

}
