package com.kata;


import org.junit.jupiter.api.Test;

import com.kata.schema.Schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author sunjing
 */
public final class ArgsParserTest {

    @Test
    public void should_false_when_boolean_default_value() {
        ArgsParser argsParser = new ArgsParser();
        assertFalse(argsParser.parse("-l").getBooleanValue("-l"));
    }

    @Test
    public void should_pass_value_when_boolean() {
        ArgsParser argsParser = new ArgsParser();
        assertTrue(argsParser.parse("-l true").getBooleanValue("-l"));
    }

    @Test
    public void should_blank_when_string_value() {
        ArgsParser argsParser = new ArgsParser();
        assertEquals("",  argsParser.parse("-s").getStringValue("-s"));
    }

    @Test
    public void should_pass_value_when_string_value() {
        ArgsParser argsParser = new ArgsParser();
        assertEquals("my",  argsParser.parse("-s").getStringValue("-s"));
    }

    @Test
    public void should_zero_when_integer_value() {
        ArgsParser argsParser = new ArgsParser();
        assertEquals(0, argsParser.parse("-i").getIntegerValue("-i"));
    }

    @Test
    public void should_pass_value_when_integer_value() {
        ArgsParser argsParser = new ArgsParser();
        assertEquals(22, argsParser.parse("-i 22").getIntegerValue("-i"));
    }

    @Test
    public void should_f_value_when_integer_value() {
        ArgsParser argsParser = new ArgsParser();
        assertEquals(-21, argsParser.parse("-i -21").getIntegerValue("-i"));
    }

    @Test
    public void should_error_when_is_invalid_schema() {
        ArgsParser argsParser = new ArgsParser();
        assertThrows(RuntimeException.class, ()->{ argsParser.parse("-h"); });
    }

    @Test
    public void should_error_when_is_invalid_schema_in_multiple() {
        ArgsParser argsParser = new ArgsParser();
        assertThrows(RuntimeException.class, ()->{ argsParser.parse("-s 23 -l -h"); });
    }

    @Test
    public void should_return_default_value_when_multiple() {
        ArgsParser argsParser = new ArgsParser();
        ArgsValue argsValue = argsParser.parse("-i -l -s");
        assertEquals(0, argsValue.getIntegerValue("-i"));
        assertFalse(argsValue.getBooleanValue("-l"));
        assertEquals("", argsValue.getStringValue("-s"));
    }

    @Test
    public void should_return_pass_value_when_multiple() {
        ArgsParser argsParser = new ArgsParser();
        ArgsValue argsValue = argsParser.parse("-i 21 -l true -s my");
        assertEquals(21, argsValue.getIntegerValue("-i"));
        assertTrue(argsValue.getBooleanValue("-l"));
        assertEquals("my", argsValue.getStringValue("-s"));
    }

    @Test
    public void should_return_default_value_when_customize() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.registerSchema(new Schema() {
            @Override
            public String flagName() {
                return "-port";
            }

            @Override
            public Object defaultValue() {
                return "8000";
            }

            @Override
            public Object parseValue(String value) {
                return value;
            }
        });
        assertEquals("8000",  argsParser.parse("-port").getStringValue("-port"));
    }

}
