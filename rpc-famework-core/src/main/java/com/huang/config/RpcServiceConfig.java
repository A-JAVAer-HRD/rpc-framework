package com.huang.config;

import lombok.*;

/**
 * @author shuang.kou
 * @createTime 2020年07月21日 20:23:00
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RpcServiceConfig {
    /**
     * 服务版本
     */
    private String version = "";
    /**
     * 当接口有多个实现类时，按组区分
     */
    private String group = "";

    /**
     * 目标服务
     */
    private Object service;

    public String getRpcServiceName() {
        return this.getServiceName() + this.getGroup() + this.getVersion();
    }

    public String getServiceName() {
        return this.service.getClass().getInterfaces()[0].getCanonicalName();
    }
}
