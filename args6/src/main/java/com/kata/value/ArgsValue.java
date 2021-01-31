package com.kata.value;

import java.util.HashMap;
import java.util.Map;

import com.kata.exception.DoesNotExistFlagValueException;

/**
 * @author sunjing
 */
public final class ArgsValue {

    private final Map<String, Object> flagToValue = new HashMap<>();

    public void put(final String flag, final Object value) {
        flagToValue.put(flag, value);
    }

    public <T> T getValue(final String flag) {
        return (T) value(flag);
    }

    private Object value(final String flag) {
        checkExistFlag(flag);
        return flagToValue.get(flag);
    }

    private void checkExistFlag(String flag) {
        if (!flagToValue.containsKey(flag)) {
            throw new DoesNotExistFlagValueException(flag);
        }
    }

}
