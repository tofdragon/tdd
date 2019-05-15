package com.kata;

/**
 * 解析配置
 *
 * @author sunjing
 */
enum ParserConfig {

    ARG_FLAG_SPLIT(" ");

    private String value;

    ParserConfig(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
