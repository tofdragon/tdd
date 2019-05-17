package com.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kata.schema.Schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class ArgsParserTest {

    private ArgsParser argsParser;

    @BeforeEach
    public void beforeEach() {
        argsParser = new ArgsParser();
    }

    @Test
    public void should_return_false_when_boolean_default_value() {
        assertFalse(getBooleanValue(argsParser.parse("-l")));
    }

    @Test
    public void should_return_true_when_boolean_true() {
        assertTrue(getBooleanValue(argsParser.parse("-l true")));
    }

    @Test
    public void should_return_blank_when_string_default_value() {
        assertEquals("", getStringValue(argsParser.parse("-s")));
    }

    @Test
    public void should_return_pass_value_when_string() {
        assertEquals("my", getStringValue(argsParser.parse("-s my")));
    }

    @Test
    public void should_return_zero_when_integer_default_value() {
        assertEquals(0, getIntegerValue(argsParser.parse("-i")));
    }

    @Test
    public void should_return_pass_value_when_integer() {
        assertEquals(111,  getIntegerValue(argsParser.parse("-i 111")));
    }

    @Test
    public void should_return_f_value_when_integer() {
        assertEquals(-21, getIntegerValue(argsParser.parse("-i -21")));
    }

    @Test
    public void should_return_error_when_do_not_match(){
        assertThrows(RuntimeException.class, ()->{ argsParser.parse("-h"); });
    }

    @Test
    public void should_return_error_when_do_not_match_in_multiple(){
        assertThrows(RuntimeException.class, ()->{ argsParser.parse("-l true -h 2 -s"); });
    }


    @Test
    public void should_return_default_value_when_multiple() {
        ArgsValue argsValue = argsParser.parse("-l -s -i");

        assertFalse(getBooleanValue(argsValue));
        assertEquals("", getStringValue(argsValue));
        assertEquals(0, getIntegerValue(argsValue));
    }

    @Test
    public void should_return_right_value_when_multiple() {
        ArgsValue argsValue = argsParser.parse("-l true -s my -i 23");

        assertTrue(getBooleanValue(argsValue));
        assertEquals("my", getStringValue(argsValue));
        assertEquals(23, getIntegerValue(argsValue));
    }

    @Test
    public void should_return_right_value_when_multiple_include_p() {
        ArgsValue argsValue = argsParser.parse("-l true -s my -i -23");

        assertTrue(getBooleanValue(argsValue));
        assertEquals("my", getStringValue(argsValue));
        assertEquals(-23, getIntegerValue(argsValue));
    }

    @Test
    public void should_default_value_when_customize() {
        registerPortSchema(argsParser);
        ArgsValue argsValue = argsParser.parse("-port");
        assertEquals("8000", argsValue.getStringValue("-port"));
    }

    private void registerPortSchema(ArgsParser argsParser) {
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
            public Object parserValue(String value) {
                return value;
            }
        });
    }

    @Test
    public void should_pass_value_when_customize() {
        registerPortSchema(argsParser);
        ArgsValue argsValue =  argsParser.parse("-port 9999 -l true");
        assertEquals("9999", argsValue.getStringValue("-port"));
    }

    private Boolean getBooleanValue(ArgsValue argsValue) {
        return argsValue.getBooleanValue("-l");
    }

    private String getStringValue(ArgsValue argsValue) {
        return argsValue.getStringValue("-s");
    }

    private Integer getIntegerValue(ArgsValue argsValue) {
        return argsValue.getIntegerValue("-i");
    }
}
