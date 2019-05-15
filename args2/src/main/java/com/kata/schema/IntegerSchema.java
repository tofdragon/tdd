package com.kata.schema;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.kata.value.IntegerValue;
import com.kata.value.ListValue;
import com.kata.value.Value;

/**
 * @author sunjing
 */
public final class IntegerSchema implements Schema<ListValue> {

    @Override
    public String flagName() {
        return "-i";
    }

    @Override
    public ListValue defaultValue() {
        return ListValue.of(IntegerValue.of("0"));
    }

    @Override
    public ListValue parseValue(String value) {
        List<Value> integerValueList = new LinkedList<>();

        for(String str : Arrays.asList(value.split(",")) ){
            integerValueList.add(IntegerValue.of(str));
        }

        return ListValue.of(integerValueList);
    }
}
