package com.kata;

public interface Schema {

    String flag();

    Object defaultValue();

    Object parserValue(String value);
}
