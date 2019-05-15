package com.kata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kata.value.Value;

/**
 * 参数的值
 *
 * @author sunjing
 */
final class ArgsValue {

    private Map<String, Value> flagNameToValue = new HashMap<>();

    void addValue(String flagName, Value value) {
        flagNameToValue.put(flagName, value);
    }

    Value getValue(String flagName) {
        return flagNameToValue.get(flagName);
    }

    Boolean getBooleanValue(String flagName) {
        return getValue(flagName).booleanValue();
    }

    String getStringValue(String flagName) {
        return getValue(flagName).stringValue();
    }

    Integer getIntegerValue(String flagName) {
        return getValue(flagName).integerValue();
    }

    List getListValue(String flagName) {
        return getValue(flagName).listValue();
    }
}
