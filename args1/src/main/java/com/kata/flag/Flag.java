package com.kata.flag;

/**
 * 标记
 * @author sunjing
 */
public interface Flag {

    /**
     * 名称
     * @return 名称
     */
    String name();

    /**
     * 默认值
     * @return 默认值
     */
    Object defaultValue();

    /**
     * 解析值
     * @param value 字符串值
     * @return 解析后的值
     */
    Object parseValue(String value);
}
