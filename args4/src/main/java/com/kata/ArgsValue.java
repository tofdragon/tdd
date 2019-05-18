package com.kata;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunjing
 */
final class ArgsValue {

    private Map<String, Object> flagNameToValue = new HashMap<>();

    void addValue(String flagName, Object flagNameOrValue) {
        flagNameToValue.put(flagName, flagNameOrValue);
    }

    private Object getValue(String flagName) {
        return flagNameToValue.get(flagName);
    }

    Boolean getBooleanValue(String flagName) {
        return Boolean.valueOf(getValue(flagName).toString());
    }

    String getStringValue(String flagName) {
        return getValue(flagName).toString();
    }

    Integer getIntegerValue(String flagName) {
        return Integer.parseInt(getValue(flagName).toString());
    }

}
