package com.kata;

import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        if (getType().equals("ListString")) {
            return Stream.of(value.split(",")).map(String::new).collect(Collectors.toList());
        }

        if (getType().equals("ListInteger")) {
            return Stream.of(value.split(",")).map(Integer::new).collect(Collectors.toList());
        }

        return value;
    }
}
