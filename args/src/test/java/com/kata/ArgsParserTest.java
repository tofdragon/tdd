package com.kata;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.kata.exception.NotExistSchemaException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 参数解析
 * @author sunjing
 */
public final class ArgsParserTest {

    @Test
    public void should_return_true_when_is_boolean_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l true");
        assertTrue(argsParser.getBooleanValue("-l"));
    }

    @Test
    public void should_return_false_when_is_boolean_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l false");
        assertFalse(argsParser.getBooleanValue("-l"));
    }

    @Test
    public void should_return_default_value_when_is_default_boolean_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l");
        assertFalse(argsParser.getBooleanValue("-l"));
    }

    @Test
    public void should_return_passed_integer_value_when_is_integer_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-i 23");

        assertEquals(23, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_passed_integer_value_when_is_a_negative_integer_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-i -23 -l");

        assertEquals(-23, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_default_value_when_is_integer_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-i");

        assertEquals(0, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_string_when_is_string_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-s 123");
        assertEquals("123", argsParser.getStringValue("-s"));
    }

    @Test
    public void should_return_default_value_when_is_string_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-s");
        assertEquals("", argsParser.getStringValue("-s"));
    }

    @Test
    public void should_return_right_value_when_is_multiple_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l true -i 23 -s 123");

        assertTrue(argsParser.getBooleanValue("-l"));
        assertEquals(23, argsParser.getIntegerValue("-i"));
        assertEquals("123", argsParser.getStringValue("-s"));
    }

    @Test
    public void should_return_right_and_boolean_default_value_when_is_multiple_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l -i 23 -s 123");

        assertFalse(argsParser.getBooleanValue("-l"));
        assertEquals(23, argsParser.getIntegerValue("-i"));
        assertEquals("123", argsParser.getStringValue("-s"));
    }

    @Test
    public void should_return_right_and_string_or_integer_default_value_when_is_multiple_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l true -i -s");

        assertTrue(argsParser.getBooleanValue("-l"));
        assertEquals(0, argsParser.getIntegerValue("-i"));
        assertEquals("", argsParser.getStringValue("-s"));
    }

    @Test
    public void should_return_all_default_value_when_is_multiple_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l -i -s");

        assertFalse(argsParser.getBooleanValue("-l"));
        assertEquals(0, argsParser.getIntegerValue("-i"));
        assertEquals("", argsParser.getStringValue("-s"));
    }

    @Test
    public void should_return_error_when_do_not_match_schema(){
        ArgsParser argsParser = new ArgsParser();
        assertThrows(NotExistSchemaException.class, ()->{ argsParser.parse("-l -i -s -h"); });
    }

    @Test
    public void should_return_right_value_when_customize_schema(){
        ArgsParser argsParser = new ArgsParser();

        argsParser.registerScheme(new Schema() {

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

        argsParser.parse("-port 8080");
        assertEquals("8080", argsParser.getStringValue("-port"));
    }

    @Test
    public void should_return_list_value_when_customize_schema(){
        ArgsParser argsParser = new ArgsParser();

        argsParser.registerScheme(new Schema() {

            @Override
            public String flagName() {
                return "-g";
            }

            @Override
            public Object defaultValue() {
                return "";
            }

            @Override
            public Object parseValue(String value) {
                if (value == null || value.equals("")) {
                    return Collections.emptyList();
                }
                return Arrays.asList(value.split(","));
            }
        });

        argsParser.parse("-g 1,2,3");

        List<String> values = (List<String>) argsParser.getValue("-g");
        assertEquals(3, values.size());
    }
}
