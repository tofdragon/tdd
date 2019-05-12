package com.kata;

/**
 * 参数值
 *
 * @author sunjing
 */
public final class ArgValue<T> {

    private T value;

    public ArgValue(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }
}
