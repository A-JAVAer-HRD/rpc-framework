package com.huang;

import com.huang.config.RpcServiceConfig;
import com.huang.proxy.RpcClientProxy;
import com.huang.remoting.transport.RpcRequestTransport;
import com.huang.remoting.transport.socket.SocketRpcClient;

/**
 * @author Huang RD
 * @date 2023/4/26 19:09
 * @description
 */
public class SocketClientMain {
    public static void main(String[] args) {
        RpcRequestTransport rpcRequestTransport = new SocketRpcClient();
        RpcServiceConfig rpcServiceConfig = new RpcServiceConfig();
        RpcClientProxy rpcClientProxy = new RpcClientProxy(rpcRequestTransport, rpcServiceConfig);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        String hello = helloService.hello(new Hello("111", "222"));
        System.out.println(hello);
    }
}
