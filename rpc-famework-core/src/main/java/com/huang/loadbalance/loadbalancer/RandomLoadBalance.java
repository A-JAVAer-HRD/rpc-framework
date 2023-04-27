package com.huang.loadbalance.loadbalancer;

import com.huang.loadbalance.AbstractLoadBalance;
import com.huang.remoting.dto.RpcRequest;

import java.util.List;
import java.util.Random;

/**
 * @author Huang RD
 * @date 2023/4/25 20:14
 * @description 随机的负载均衡
 */
public class RandomLoadBalance extends AbstractLoadBalance {
    @Override
    protected String doSelect(List<String> serviceAddresses, RpcRequest rpcRequest) {
        Random random = new Random();
        return serviceAddresses.get(random.nextInt(serviceAddresses.size()));
    }
}
