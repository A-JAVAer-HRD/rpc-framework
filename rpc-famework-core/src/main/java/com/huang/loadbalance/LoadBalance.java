package com.huang.loadbalance;

import com.huang.extension.SPI;
import com.huang.remoting.dto.RpcRequest;

import java.util.List;

/**
 * @author Huang RD
 * @date 2023/4/25 20:08
 * @description 负载均衡接口
 */
@SPI
public interface LoadBalance {

    /**
     * 从服务列表中选择一个服务
     *
     * @param serviceUrlList 服务列表
     * @param rpcRequest
     * @return 目标服务的地址
     */
    String selectServiceAddress(List<String> serviceUrlList, RpcRequest rpcRequest);

}
