package com.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class ArgsParserTest {

    @Test
    public void should_return_false_when_boolean_default_value() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l");
        assertFalse(argsParser.getBooleanValue("-l"));
    }

    @Test
    public void should_return_true_when_boolean_true() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l true");
        assertTrue(argsParser.getBooleanValue("-l"));
    }

    @Test
    public void should_return_blank_when_string_default_value() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-s");
        assertEquals("", argsParser.getStringValue("-s"));
    }

    @Test
    public void should_return_pass_value_when_string() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-s my");
        assertEquals("my", argsParser.getStringValue("-s"));
    }

    @Test
    public void should_return_zero_when_integer_default_value() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-i");
        assertEquals(0, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_pass_value_when_integer() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-i 111");
        assertEquals(111, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_f_value_when_integer() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-i -21");
        assertEquals(-21, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_error_when_do_not_match(){
        ArgsParser argsParser = new ArgsParser();
        assertThrows(RuntimeException.class, ()->{ argsParser.parse("-h"); });
    }

    @Test
    public void should_return_error_when_do_not_match_in_multiple(){
        ArgsParser argsParser = new ArgsParser();
        assertThrows(RuntimeException.class, ()->{ argsParser.parse("-l true -h 2 -s"); });
    }


    @Test
    public void should_return_default_value_when_multiple() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l -s -i");

        assertFalse(argsParser.getBooleanValue("-l"));
        assertEquals("", argsParser.getStringValue("-s"));
        assertEquals(0, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_right_value_when_multiple() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l true -s my -i 23");

        assertTrue(argsParser.getBooleanValue("-l"));
        assertEquals("my", argsParser.getStringValue("-s"));
        assertEquals(23, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_right_value_when_multiple_include_p() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l true -s my -i -23");

        assertTrue(argsParser.getBooleanValue("-l"));
        assertEquals("my", argsParser.getStringValue("-s"));
        assertEquals(-23, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_default_value_when_customize() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.registerSchema("-port", 8000);
        argsParser.parse("-port");
        assertEquals("8000", argsParser.getStringValue("-port"));
    }

    @Test
    public void should_pass_value_when_customize() {
        ArgsParser argsParser = new ArgsParser();
        argsParser.registerSchema("-port", 8000);
        argsParser.parse("-port 9999 -l true");
        assertEquals("9999", argsParser.getStringValue("-port"));
    }
}
