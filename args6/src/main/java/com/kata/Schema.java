package com.kata;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * @author sunjing
 */
public abstract class Schema<T> {

    @Getter
    private final String flag;

    @Getter(value = AccessLevel.PRIVATE)
    private final String defaultValue;

    public Schema(final String flag, final String defaultValue) {
        this.flag = flag;
        this.defaultValue = defaultValue;
    }

    public T parse(String arg) {
        String value = arg == null ? getDefaultValue() : arg;
        return doParse(value);
    }

    protected abstract T doParse(String value);
}
