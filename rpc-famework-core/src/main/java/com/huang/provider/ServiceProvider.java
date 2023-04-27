package com.huang.provider;


import com.huang.config.RpcServiceConfig;

/**
 * 存储和提供服务对象
 */
public interface ServiceProvider {

    /**
     * @param rpcServiceConfig rpc服务相关属性
     */
    void addService(RpcServiceConfig rpcServiceConfig);

    /**
     * @param rpcServiceName rpc 服务名称
     * @return service 对象
     */
    Object getService(String rpcServiceName);

    /**
     * @param rpcServiceConfig rpc服务相关属性
     */
    void publishService(RpcServiceConfig rpcServiceConfig);

}
