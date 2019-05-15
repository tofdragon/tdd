package com.kata.schema;

import com.kata.value.Value;

/**
 * 〈功能详细描述〉 描述
 *
 * @author sunjing
 * @since [产品/模块版本]
 */
public interface Schema<T extends Value> {

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
    T defaultValue();

    /**
     * 解析后的值
     *
     * @param value 字符串值
     * @return 解析后的值
     */
    T parseValue(String value);

}
