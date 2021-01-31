package com.kata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kata.exception.DoesNotExistFlagValueException;

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
        return (Integer) value(flag);
    }

    private Object value(final String flag) {
        checkExistFlag(flag);
        return flagToValue.get(flag);
    }

    public String getString(String flag) {
        checkExistFlag(flag);
        return (String) value(flag);
    }

    private void checkExistFlag(String flag) {
        if (!flagToValue.containsKey(flag)) {
            throw new DoesNotExistFlagValueException(flag);
        }
    }

    public List<String> getListString(String flag) {
        return (List<String>) value(flag);
    }

    public List<Integer> getListInteger(String flag) {
        return (List<Integer>) value(flag);
    }
}
