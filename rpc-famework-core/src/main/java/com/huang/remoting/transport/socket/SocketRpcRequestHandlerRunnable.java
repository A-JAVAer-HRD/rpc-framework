package com.huang.remoting.transport.socket;

import com.huang.factory.SingletonFactory;
import com.huang.remoting.dto.RpcRequest;
import com.huang.remoting.dto.RpcResponse;
import com.huang.remoting.handler.RpcRequestHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author Huang RD
 * @date 2023/4/24 19:44
 * @description 线程对象，处理一个RpcRequest
 */
@Slf4j
public class SocketRpcRequestHandlerRunnable implements Runnable {

    private final Socket socket;
    private final RpcRequestHandler rpcRequestHandler;

    public SocketRpcRequestHandlerRunnable(Socket socket) {
        this.socket = socket;
        this.rpcRequestHandler = SingletonFactory.getInstance(RpcRequestHandler.class);
    }

    @Override
    public void run() {
        log.info("server handle message from client by thread: [{}]", Thread.currentThread().getName());
        try (ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {
            // 读入RpcRequest
            RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();
            // 通过RpcRequestHandler处理RpcRequest
            Object result = rpcRequestHandler.handle(rpcRequest);
            objectOutputStream.writeObject(RpcResponse.success(result, rpcRequest.getRequestId()));
            objectOutputStream.flush();
        } catch (IOException | ClassNotFoundException e) {
            log.error("occur exception:", e);
        }
    }
}
