package com.huang.registry;

import com.huang.extension.SPI;
import com.huang.remoting.dto.RpcRequest;

import java.net.InetSocketAddress;

/**
 * @author Huang RD
 * @date 2023/4/25 19:35
 * @description 服务发现
 */
@SPI
public interface ServiceDiscovery {

    /**
     * 通过 rpcServiceName 查找服务
     * @param rpcRequest
     * @return 服务地址
     */
    InetSocketAddress lookupService(RpcRequest rpcRequest);

}
