package com.kata;

import java.util.Optional;

/**
 * @author sunjing
 */
public interface Schema<T> {

    /**
     * 标记
     * @return 标记
     */
    String flag();

    /**
     * 解析值
     * @param value 值
     * @return 解析后的值
     */
    T parse(final Optional<String> value);
}
