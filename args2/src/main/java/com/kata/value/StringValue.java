package com.kata.value;

/**
 * 〈功能详细描述〉 描述
 *
 * @author sunjing
 * @since [产品/模块版本]
 */
public final class StringValue implements Value<String> {

    private String value;

    private StringValue() {
    }

    public static StringValue of(String value) {
        StringValue stringValue = new StringValue();
        stringValue.value = value;
        return stringValue;
    }

    @Override
    public String value() {
        return value;
    }


}
