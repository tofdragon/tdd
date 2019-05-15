package com.kata.value;

import java.util.Collections;
import java.util.List;

/**
 * 参数的值
 *
 * @author sunjing
 */
public interface Value<T> {

    /**
     * 当前的实际值类型
     *
     * @return 实际值类型
     */
    T value();

    /**
     * 转String类型值
     *
     * @return 转String类型值
     */
    default String stringValue() {
        return value().toString();
    }

    /**
     * 转Integer类型值
     *
     * @return 转Integer类型值
     */
    default Integer integerValue() {
        return Integer.parseInt(stringValue());
    }

    /**
     * 转Boolean类型值
     *
     * @return 转Boolean类型值
     */
    default Boolean booleanValue() {
        return Boolean.valueOf(stringValue());
    }

    /**
     * 转List类型值
     *
     * @return 转List类型值
     */
    default List<T> listValue() {
        return Collections.emptyList();
    }

}
