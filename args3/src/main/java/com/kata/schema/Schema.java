package com.kata.schema;

/**
 * schema
 *
 * @author sunjing
 */
public interface Schema {

    /**
     * 标记名称
     * @return 标记名称
     */
    String flagName();

    /**
     * 默认值
     * @return 默认值
     */
    Object defaultValue();

    /**
     * 解析后的值
     * @param value 需要解析的值
     * @return 解析后的值
     */
    Object parserValue(String value);
}
