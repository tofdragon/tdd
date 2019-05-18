package com.kata.schema;

/**
 * 〈功能详细描述〉 描述
 *
 * @author sunjing
 * @since [产品/模块版本]
 */
public interface Schema {

    String flagName();

    Object defaultValue();

    Object parseValue(String value);
}
