package com.huang.annotation;


import java.lang.annotation.*;

/**
 * RPC引用注解，自动装配服务实现类
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Inherited
public @interface RpcReference {

    /**
     * 服务版本，默认为空串
     */
    String version() default "";

    /**
     * 服务组，默认为空串
     */
    String group() default "";

}
