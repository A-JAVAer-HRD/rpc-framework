package com.huang.loadbalance;

import com.huang.remoting.dto.RpcRequest;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author Huang RD
 * @date 2023/4/25 20:10
 * @description 负载均衡策略的抽象类
 */
public abstract class AbstractLoadBalance implements LoadBalance {

    @Override
    public String selectServiceAddress(List<String> serviceAddress, RpcRequest rpcRequest) {
        if (CollectionUtils.isEmpty(serviceAddress)) {
            return null;
        }
        if (serviceAddress.size() == 1) {
            return serviceAddress.get(0);
        }
        return doSelect(serviceAddress, rpcRequest);
    }

    protected abstract String doSelect(List<String> serviceAddresses, RpcRequest rpcRequest);

}
