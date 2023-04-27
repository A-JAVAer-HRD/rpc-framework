package com.huang.registry;

import com.huang.extension.SPI;

import java.net.InetSocketAddress;

/**
 * @author Huang RD
 * @date 2023/4/25 19:35
 * @description 服务注册
 */
@SPI
public interface ServiceRegistry {

    /**
     * 注册服务
     * @param rpcServiceName rpc 服务名
     * @param inetSocketAddress 服务地址
     */
    void registerService(String rpcServiceName, InetSocketAddress inetSocketAddress);

}
