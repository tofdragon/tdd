package com.kata;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.management.StringValueExp;

import org.junit.jupiter.api.Test;

import com.kata.schema.Schema;
import com.kata.value.IntegerValue;
import com.kata.value.ListValue;
import com.kata.value.StringValue;
import com.kata.value.Value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 参数解析测试
 * @author sunjing
 */
public class ArgsParserTest {


    @Test
    public void should_return_false_when_boolean_default_value(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l");

        assertFalse(argsParser.getBooleanValue("-l"));
    }

    @Test
    public void should_return_true_when_boolean_true_value(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l true");

        assertTrue(argsParser.getBooleanValue("-l"));
    }

    @Test
    public void should_return_white_string_when_string_default_value(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-s");

        assertEquals("", argsParser.getStringValue("-s"));
    }

    @Test
    public void should_return_right_value_when_string_value(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-s my");

        assertEquals("my", argsParser.getStringValue("-s"));
    }


    @Test
    public void should_return_zero_when_integer_default_value(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-i");

        assertEquals(0, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_right_value_when_integer(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-i 22");

        assertEquals(22, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_negative_value_when_integer(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-i -2");

        assertEquals(-2, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_default_value_when_multiple(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l -s -i");

        assertFalse(argsParser.getBooleanValue("-l"));
        assertEquals("", argsParser.getStringValue("-s"));
        assertEquals(0, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_right_boolean_and_string_value_when_multiple(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-l true -s my -i");

        assertTrue(argsParser.getBooleanValue("-l"));
        assertEquals("my", argsParser.getStringValue("-s"));
        assertEquals(0, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_right_boolean_and_integer_value_when_multiple(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-s -l -i 23");

        assertFalse(argsParser.getBooleanValue("-l"));
        assertEquals("", argsParser.getStringValue("-s"));
        assertEquals(23, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_all_right_value_when_multiple(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-s my -l false -i 23");

        assertFalse(argsParser.getBooleanValue("-l"));
        assertEquals("my", argsParser.getStringValue("-s"));
        assertEquals(23, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_all_right_value_when_multiple_in_diff_order(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-s my -i -1 -l");

        assertFalse(argsParser.getBooleanValue("-l"));
        assertEquals("my", argsParser.getStringValue("-s"));
        assertEquals(-1, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_error_when_do_not_match(){
        ArgsParser argsParser = new ArgsParser();
        assertThrows(RuntimeException.class, ()->{ argsParser.parse("-h"); });
    }

    @Test
    public void should_return_error_when_do_not_match_in_multiple(){
        ArgsParser argsParser = new ArgsParser();
        assertThrows(RuntimeException.class, ()->{ argsParser.parse("-s my -l false -h 23"); });
    }

    @Test
    public void should_return_all_right_value_when_customize(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parse("-s my -i -1 -port 8888");

        assertFalse(argsParser.getBooleanValue("-s"));
        assertEquals("8888", argsParser.getStringValue("-port"));
        assertEquals(-1, argsParser.getIntegerValue("-i"));
    }

    @Test
    public void should_return_list_value_when_customize(){
        ArgsParser argsParser = new ArgsParser();

        argsParser.registerSchema(new Schema<ListValue>() {
            @Override
            public String flagName() {
                return "-g";
            }

            @Override
            public ListValue defaultValue() {
                return ListValue.of(Collections.emptyList());
            }

            @Override
            public ListValue parseValue(String value) {
                List<Value> integerValueList = new LinkedList<>();

                for(String str : Arrays.asList(value.split(","))){
                    integerValueList.add(IntegerValue.of(str));
                }

                return ListValue.of(integerValueList);
            }
        });

        argsParser.parse("-g 1,2,3,4 -i -1 -port 8888");

        assertEquals(4, argsParser.getListValue("-g").size());
    }


}
