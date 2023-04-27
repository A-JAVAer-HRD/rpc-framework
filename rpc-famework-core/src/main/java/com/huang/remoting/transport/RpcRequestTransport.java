package com.huang.remoting.transport;

import com.huang.extension.SPI;
import com.huang.remoting.dto.RpcRequest;

/**
 * @author Huang RD
 * @date 2023/4/24 19:38
 * @description 发送 RpcRequest
 */
@SPI
public interface RpcRequestTransport {

    /**
     * 发送 Rpc request 到服务器，获取返回的 rpc response
     * @param rpcRequest message body
     * @return Response body
     */
    Object sendRpcRequest(RpcRequest rpcRequest);

}
