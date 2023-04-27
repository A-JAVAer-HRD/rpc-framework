package com.huang.remoting.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RpcMessage {

    /**
     * rpc message 类型
     */
    private byte messageType;
    /**
     * 序列化类型
     */
    private byte codec;
    /**
     * 压缩类型
     */
    private byte compress;
    /**
     * request id
     */
    private int requestId;
    /**
     * request data
     */
    private Object data;

}
