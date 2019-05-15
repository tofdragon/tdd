package com.kata.value;

/**
 * 〈功能详细描述〉 描述
 *
 * @author sunjing
 * @since [产品/模块版本]
 */
public final class BooleanValue implements Value<Boolean> {

    private Boolean value;

    private BooleanValue() {
    }

    public static BooleanValue of(String value) {
        BooleanValue booleanValue = new BooleanValue();
        booleanValue.value = Boolean.valueOf(value);
        return booleanValue;
    }

    public static BooleanValue falseValue() {
        BooleanValue booleanValue = new BooleanValue();
        booleanValue.value = false;
        return booleanValue;
    }

    @Override
    public Boolean value() {
        return value;
    }
}
