package com.kata.value;

import java.util.HashMap;
import java.util.Map;

/**
 * 参数值
 *
 * @author sunjing
 */
public final class ArgsValues {

    private final Map<String, Object> flagToValue;

    public ArgsValues() {
        flagToValue = new HashMap<>();
    }

    public void add(final String flag, final Object value) {
        flagToValue.put(flag, value);
    }

    public <T> T getValue(final String flag) {
        return (T) flagToValue.get(flag);
    }
}
