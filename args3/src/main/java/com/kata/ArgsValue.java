package com.kata;

import java.util.HashMap;
import java.util.Map;

/**
 * 参数值
 *
 * @author sunjing
 */
public class ArgsValue {

    private final Map<String, Object> flagNameToValue = new HashMap<>();

    void addValue(String flagName, Object value) {
        flagNameToValue.put(flagName, value);
    }

    public boolean getBooleanValue(String flagName) {
        return Boolean.valueOf(getValue(flagName).toString());
    }

    public String getStringValue(String flagName) {
        return getValue(flagName).toString();
    }

    public Integer getIntegerValue(String flagName) {
        return Integer.parseInt(getValue(flagName).toString());
    }

    private Object getValue(String flagName) {
        return flagNameToValue.get(flagName);
    }
}
