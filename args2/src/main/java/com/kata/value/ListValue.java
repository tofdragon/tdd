package com.kata.value;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sunjing
 */
public final class ListValue implements Value<Value> {

    private List<Value> value;

    private ListValue() {
        value = new LinkedList<>();
    }

    public static ListValue of(Value value) {
        ListValue listValue = new ListValue();
        listValue.value.add(value);
        return listValue;
    }

    public static  ListValue of(List<Value> values) {
        ListValue listValue = new ListValue();
        listValue.value.addAll(values);
        return listValue;
    }

    @Override
    public Value value() {
        return value.get(0);
    }

    @Override
    public String stringValue() {
        return value().value().toString();
    }

    @Override
    public List<Value> listValue() {
        return value;
    }
}
