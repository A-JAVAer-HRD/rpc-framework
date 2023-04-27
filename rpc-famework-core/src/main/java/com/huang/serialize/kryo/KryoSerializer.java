package com.huang.serialize.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.huang.exception.SerializeException;
import com.huang.remoting.dto.RpcRequest;
import com.huang.remoting.dto.RpcResponse;
import com.huang.serialize.Serializer;
import lombok.extern.slf4j.Slf4j;

import javax.sql.rowset.serial.SerialException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.function.Supplier;

/**
 * @author Huang RD
 * @date 2023/4/24 17:23
 * @description Kryo序列化类，Kryo序列化效率很高，但只兼容Java语言
 */
@Slf4j
public class KryoSerializer implements Serializer {

    // 因为 Kryo 不是线程安全的, 使用 ThreadLocal 来存储 Kryo 对象
    private final ThreadLocal<Kryo> kryoThreadLocal = ThreadLocal.withInitial(new Supplier<Kryo>() {
        @Override
        public Kryo get() {
            Kryo kryo = new Kryo();
            kryo.register(RpcResponse.class);
            kryo.register(RpcRequest.class);
            return kryo;
        }
    });

    @Override
    public byte[] serialize(Object obj) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             Output output = new Output(byteArrayOutputStream)) {
            Kryo kryo = kryoThreadLocal.get();
            // Object -> byte，将对象序列化为byte数组
            kryo.writeObject(output, obj);
            kryoThreadLocal.remove();
            return output.toBytes();
        } catch (Exception e) {
            throw new SerializeException("Serialization failed");
        }
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
             Input input = new Input(byteArrayInputStream)) {
            Kryo kryo = kryoThreadLocal.get();
            // byte->Object:从byte数组中反序列化出对对象
            Object o = kryo.readObject(input, clazz);
            kryoThreadLocal.remove();
            return clazz.cast(o);
        } catch (Exception e) {
            throw new SerializeException("Deserialization failed");
        }
    }
}
