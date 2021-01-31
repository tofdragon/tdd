package com.kata;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunjing
 */
public final class ArgsValue {

    private final Map<String, Object> flagToValue = new HashMap<>();

    public Boolean getBoolean(final String flag) {
        return (Boolean) flagToValue.get(flag);
    }

    public void put(final String flag, final Object value) {
        flagToValue.put(flag, value);
    }

    public Integer getInteger(final String flag) {
        return (Integer) flagToValue.get(flag);
    }

    public String getString(String flag) {
        return (String) flagToValue.get(flag);
    }
}
