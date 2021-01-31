package com.kata;

import lombok.Getter;

/**
 * @author sunjing
 */
@Getter
public final class Schema {

    private final String flag;

    private final String type;

    private final String defaultValue;

    public Schema(final String flag, final String type, final String defaultValue) {
        this.flag = flag;
        this.type = type;
        this.defaultValue = defaultValue;
    }

    public Object parse(String arg) {
        String value = arg == null ? getDefaultValue() : arg;
        if (getType().equals("Boolean")) {
            return Boolean.valueOf(value);
        }

        if (getType().equals("Integer")) {
            return Integer.valueOf(value);
        }

        if (getType().equals("String")) {
            return value;
        }

        return value;
    }
}
