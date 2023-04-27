package com.huang.extension;

/**
 * @author Huang RD
 * @date 2023/4/24 20:26
 * @description
 */
public class Holder<T> {

    private volatile T value;

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }
}
