package com.kata.schema;

import java.util.Optional;

import com.kata.Schema;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * @author sunjing
 */
public abstract class AbstractSchema<T> implements Schema<T>{

    private final String flag;

    @Getter(value = AccessLevel.PRIVATE)
    private final String defaultValue;

    public AbstractSchema(final String flag, final String defaultValue) {
        this.flag = flag;
        this.defaultValue = defaultValue;
    }

    @Override
    public String flag() {
        return flag;
    }

    @Override
    public T parse(final Optional<String> value) {
        return value.map(this::parseValue).orElseGet(() -> parseValue(getDefaultValue()));
    }

    /**
     * 解析值
     * @param value 值
     * @return 解析后的值
     */
    protected abstract T parseValue(String value);
}
