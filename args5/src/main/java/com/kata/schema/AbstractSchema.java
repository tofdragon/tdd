package com.kata.schema;

import java.util.Optional;

/**
 * schema
 *
 * @author sunjing
 * @since 1.0.0
 */
public abstract class AbstractSchema<T> implements Schema<T> {

    private final String flag;

    private final String defaultValue;

    protected AbstractSchema(final String flag, final String defaultValue) {
        this.flag = flag;
        this.defaultValue = defaultValue;
    }

    @Override
    public String flag() {
        return flag;
    }

    @Override
    public String defaultValue() {
        return defaultValue;
    }

    @Override
    public T parse(Optional<String> value) {
        return value.map(this::parseValue).orElseGet(() -> parseValue(defaultValue()));
    }

    /**
     * 解析值
     *
     * @param value 值
     * @return 解析后的值
     */
    protected abstract T parseValue(final String value);
}
