package com.kata;

/**
 * Schema
 * @author sunjing
 */
public interface Schema {

    /**
     * 标记名称
     *
     * @return 标记名称
     */
    String flagName();

    /**
     * 默认值
     *
     * @return 默认值
     */
    Object defaultValue();

    /**
     * 解析值
     *
     * @param value 字符串值
     * @return 解析后的值
     */
    Object parseValue(String value);
}
