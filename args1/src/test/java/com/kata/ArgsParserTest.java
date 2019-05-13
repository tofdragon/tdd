package com.kata;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.kata.flag.Flag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author sunjing
 */
public class ArgsParserTest {

    @Test
    public void should_return_false_when_boolean_default_flag() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l");
        assertFalse(argsParser.getBooleanValue("-l"));
    }

    @Test
    public void should_return_true_when_boolean_flag() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l true");
        assertTrue(argsParser.getBooleanValue("-l"));
    }

    @Test
    public void should_return_white_blank_when_string_default_flag() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-s");
        assertEquals("", argsParser.getStringValue("-s"));
    }

    @Test
    public void should_return_string_value_when_string_flag() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-s name");
        assertEquals("name", argsParser.getStringValue("-s"));
    }

    @Test
    public void should_return_zero_when_integer_default_flag() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-i");
        assertEquals(0, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_integer_value_when_string_flag() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-i 100");
        assertEquals(100, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_negative_integer_value_when_string_flag() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-i -21");
        assertEquals(-21, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_right_value_when_multiple_flag() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l true -i 21 -s name");

        assertTrue(argsParser.getBooleanValue("-l"));
        assertEquals(21, argsParser.getIntegerValue("-i"));
        assertEquals("name", argsParser.getStringValue("-s"));
    }

    @Test
    public void should_return_default_value_when_multiple_flag() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l -i -s");

        assertFalse(argsParser.getBooleanValue("-l"));
        assertEquals(0, argsParser.getIntegerValue("-i"));
        assertEquals("", argsParser.getStringValue("-s"));
    }

    @Test
    public void should_return_negative_integer_when_multiple_flag() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l -i -1 -s 23");

        assertFalse(argsParser.getBooleanValue("-l"));
        assertEquals(-1, argsParser.getIntegerValue("-i"));
        assertEquals("23", argsParser.getStringValue("-s"));
    }

    @Test
    public void should_return_right_value_and_default_value_when_multiple_flag() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-i -l false -s");

        assertEquals(0, argsParser.getIntegerValue("-i"));
        assertFalse(argsParser.getBooleanValue("-l"));
        assertEquals("", argsParser.getStringValue("-s"));
    }

    @Test
    public void should_return_error_when_do_not_match_flag(){
        ArgsParser argsParser = new ArgsParser();
        assertThrows(RuntimeException.class, ()->{ argsParser.parse("-h"); });
    }

    @Test
    public void should_return_error_when_do_not_match_schema_in_multiple_flag(){
        ArgsParser argsParser = new ArgsParser();
        assertThrows(RuntimeException.class, ()->{ argsParser.parse("-i 21 -h -l "); });
        assertThrows(RuntimeException.class, ()->{ argsParser.parse("-i -h -l "); });
    }

    @Test
    public void should_return_default_value_when_customize_flag(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-port");
        assertEquals("8000", argsParser.getStringValue("-port"));
    }

    @Test
    public void should_return_right_value_when_customize_flag(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-port 8080 -l false -i 23");
        assertEquals("8080", argsParser.getStringValue("-port"));
        assertFalse(argsParser.getBooleanValue("-l"));
        assertEquals("23", argsParser.getStringValue("-i"));
    }

    @Test
    public void should_return_right_value_when_customize_array_flag(){
        ArgsParser argsParser = new ArgsParser();

        argsParser.registerFlag(new Flag(){

            @Override
            public String name() {
                return "-g";
            }

            @Override
            public Object defaultValue() {
                return Collections.emptyList();
            }

            @Override
            public Object parseValue(String value) {
                return Arrays.asList(value.split(","));
            }
        });
        argsParser.parse("-g 1,2,3,4 -l false -i 23");

        assertEquals(4, ((List)argsParser.getValue("-g")).size());
        assertFalse(argsParser.getBooleanValue("-l"));
        assertEquals("23", argsParser.getStringValue("-i"));
    }

}
