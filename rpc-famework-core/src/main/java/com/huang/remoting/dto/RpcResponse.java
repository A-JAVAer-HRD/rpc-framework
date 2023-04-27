package com.huang.remoting.dto;

import com.huang.enums.RpcResponseCodeEnum;
import lombok.*;

import java.io.Serializable;

/**
 * @author Huang RD
 * @date 2023/4/24 18:45
 * @description
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder // 使用创建者模式或建造者模式来生成对象
@ToString
public class RpcResponse<T> implements Serializable {

    private static final long serialVersionUID = 715745410605631233L;
    private String requestId;
    /**
     * 响应码
     */
    private Integer code;
    private String message;
    private T data;

    public static <T> RpcResponse<T> success(T data, String requestId) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setCode(RpcResponseCodeEnum.SUCCESS.getCode());
        response.setMessage(RpcResponseCodeEnum.SUCCESS.getMessage());
        response.setRequestId(requestId);
        if (data != null) {
            response.setData(data);
        }
        return response;
    }

    public static <T> RpcResponse<T> fail(RpcResponseCodeEnum rpcResponseCodeEnum) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setCode(rpcResponseCodeEnum.getCode());
        response.setMessage(rpcResponseCodeEnum.getMessage());
        return response;
    }

}
