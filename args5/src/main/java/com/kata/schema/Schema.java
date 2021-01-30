package com.kata.schema;

import java.util.Optional;

/**
 * Schema
 *
 * @author sunjing
 */
public interface Schema<T> {

    /**
     * 标记
     *
     * @return 标记
     */
    String flag();

    /**
     * 默认值
     *
     * @return 默认值
     */
    String defaultValue();

    /**
     * 解析值
     *
     * @param value 值
     * @return 解析后的值
     */
    T parse(Optional<String> value);
}
