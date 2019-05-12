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
        argsParser.parser("-l true");
        assertTrue(Boolean.valueOf(argsParser.getValue("-l").toString()));
    }

    @Test
    public void should_return_false_when_is_boolean_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parser("-l false");
        assertFalse(Boolean.valueOf(argsParser.getValue("-l").toString()));
    }

    @Test
    public void should_return_default_value_when_is_default_boolean_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parser("-l");
        assertFalse(Boolean.valueOf(argsParser.getValue("-l").toString()));
    }

    @Test
    public void should_return_passed_integer_value_when_is_integer_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parser("-i 23");

        assertEquals(23, Integer.parseInt(argsParser.getValue("-i").toString()));
    }

    @Test
    public void should_return_default_value_when_is_integer_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parser("-i");

        assertEquals(0, Integer.parseInt(argsParser.getValue("-i").toString()));
    }

    @Test
    public void should_return_string_when_is_string_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parser("-s 123");
        assertEquals("123", argsParser.getValue("-s"));
    }

    @Test
    public void should_return_default_value_when_is_string_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parser("-s");
        assertEquals("", argsParser.getValue("-s"));
    }

    @Test
    public void should_return_right_value_when_is_multiple_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parser("-l true -i 23 -s 123");

        assertTrue(Boolean.valueOf(argsParser.getValue("-l").toString()));
        assertEquals(23, Integer.parseInt(argsParser.getValue("-i").toString()));
        assertEquals("123", argsParser.getValue("-s"));
    }

    @Test
    public void should_return_right_and_boolean_default_value_when_is_multiple_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parser("-l -i 23 -s 123");

        assertFalse(Boolean.valueOf(argsParser.getValue("-l").toString()));
        assertEquals(23, Integer.parseInt(argsParser.getValue("-i").toString()));
        assertEquals("123", argsParser.getValue("-s"));
    }

    @Test
    public void should_return_right_and_string_or_integer_default_value_when_is_multiple_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parser("-l true -i -s");

        assertTrue(Boolean.valueOf(argsParser.getValue("-l").toString()));
        assertEquals(0, Integer.parseInt(argsParser.getValue("-i").toString()));
        assertEquals("", argsParser.getValue("-s"));
    }

    @Test
    public void should_return_all_default_value_when_is_multiple_scheme_args(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parser("-l -i -s");

        assertFalse(Boolean.valueOf(argsParser.getValue("-l").toString()));
        assertEquals(0, Integer.parseInt(argsParser.getValue("-i").toString()));
        assertEquals("", argsParser.getValue("-s"));
    }

    @Test
    public void should_return_error_when_do_not_match_schema(){
        ArgsParser argsParser = new ArgsParser();
        assertThrows(NotExistSchemaException.class, ()->{ argsParser.parser("-l -i -s -h"); });
    }

    @Test
    public void should_return_right_value_when_customize_schema(){
        ArgsParser argsParser = new ArgsParser();

        argsParser.registerScheme(new Schema() {

            @Override
            public String flag() {
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

        argsParser.parser("-port 8080");
        assertEquals("8080", argsParser.getValue("-port").toString());
    }

    @Test
    public void should_return_list_value_when_customize_schema(){
        ArgsParser argsParser = new ArgsParser();

        argsParser.registerScheme(new Schema() {

            @Override
            public String flag() {
                return "-g";
            }

            @Override
            public Object defaultValue() {
                return "";
            }

            @Override
            public Object parserValue(String value) {
                if (value == null || value.equals("")) {
                    return Collections.emptyList();
                }
                return Arrays.asList(value.split(","));
            }
        });

        argsParser.parser("-g 1,2,3");

        List<String> values = (List<String>) argsParser.getValue("-g");
        assertEquals(3, values.size());
    }
}
