package com.kata;

import java.util.List;

import org.hamcrest.core.Is;
import org.junit.Test;
import com.kata.exception.DoesNotExistFlagInSchemaException;
import com.kata.exception.DoesNotExistFlagValueException;
import com.kata.schema.builder.SchemasBuilder;

import static org.junit.Assert.assertThat;

/**
 * @author sunjing
 */
public class ArgumentParserTest {

    @Test
    public void should_false_default_value_when_boolean_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser(booleanSchema("false").build());

        //when
        Arguments arguments = argumentParser.parse("-l");

        //then
        assertThat(arguments.getValue("l"), Is.is(false));
    }

    private SchemasBuilder booleanSchema(String defaultValue) {
        return SchemasBuilder.builder().booleanSchema("l", defaultValue);
    }

    @Test
    public void should_true_default_value_when_boolean_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser(booleanSchema("true").build());

        //when
        Arguments arguments = argumentParser.parse("-l");

        //then
        assertThat(arguments.getValue("l"), Is.is(true));
    }

    @Test
    public void should_0_default_value_when_integer_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser(integerSchema("0").build());

        //when
        Arguments arguments = argumentParser.parse("-p");

        //then
        assertThat(arguments.getValue("p"), Is.is(0));
    }

    private SchemasBuilder integerSchema(String defaultValue) {
        return SchemasBuilder.builder().integerSchema("p", defaultValue);
    }

    @Test
    public void should_8080_default_value_when_integer_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser(integerSchema("8080").build());

        //when
        Arguments arguments = argumentParser.parse("-p");

        //then
        assertThat(arguments.getValue("p"), Is.is(8080));
    }

    @Test
    public void should_white_default_value_when_string_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser(stringSchema("").build());

        //when
        Arguments arguments = argumentParser.parse("-d");

        //then
        assertThat(arguments.getValue("d"), Is.is(""));
    }

    private SchemasBuilder stringSchema(String defaultValue) {
        return SchemasBuilder.builder().stringSchema("d", defaultValue);
    }

    @Test
    public void should_test_default_value_when_string_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser(stringSchema("test").build());

        //when
        Arguments arguments = argumentParser.parse("-d");

        //then
        assertThat(arguments.getValue("d"), Is.is("test"));
    }

    @Test
    public void should_true_when_has_value_and_boolean_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser(booleanSchema("false").build());

        //when
        Arguments arguments = argumentParser.parse("-l true");

        //then
        assertThat(arguments.getValue("l"), Is.is(true));
    }

    @Test
    public void should_false_when_has_value_and_boolean_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser(booleanSchema("true").build());

        //when
        Arguments arguments = argumentParser.parse("-l false");

        //then
        assertThat(arguments.getValue("l"), Is.is(false));
    }

    @Test
    public void should_8080_when_has_value_integer_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser(integerSchema("0").build());

        //when
        Arguments arguments = argumentParser.parse("-p 8080");

        //then
        assertThat(arguments.getValue("p"), Is.is(8080));
    }

    @Test
    public void should_test21_when_has_value_string_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser(stringSchema("").build());

        //when
        Arguments arguments = argumentParser.parse("-d test21");

        //then
        assertThat(arguments.getValue("d"), Is.is("test21"));
    }

    @Test
    public void should_default_value_when_boolean_string_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser((
                booleanSchema("false").stringSchema("d", "0").build()));

        //when
        Arguments arguments = argumentParser.parse("-l -d");

        //then
        assertThat(arguments.getValue("l"), Is.is(false));
        assertThat(arguments.getValue("d"), Is.is("0"));
    }

    @Test
    public void should_default_value_when_integer_string_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser(
                integerSchema("9999").
                        stringSchema("d", "test21").build());

        //when
        Arguments arguments = argumentParser.parse("-p -d");

        //then
        assertThat(arguments.getValue("p"), Is.is(9999));
        assertThat(arguments.getValue("d"), Is.is("test21"));
    }

    @Test
    public void should_default_value_when_boolean_integer_string_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser(
                booleanSchema("false").
                        integerSchema("p", "9999").
                        stringSchema("d", "test21").build());

        //when
        Arguments arguments = argumentParser.parse("-p -d -l");

        //then
        assertThat(arguments.getValue("l"), Is.is(false));
        assertThat(arguments.getValue("p"), Is.is(9999));
        assertThat(arguments.getValue("d"), Is.is("test21"));
    }

    @Test
    public void should_true_and_string_value_when_has_value_boolean_string_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser(
                booleanSchema("false").
                        stringSchema("d", "").build());

        //when
        Arguments arguments = argumentParser.parse("-d /usr/logs -l true");

        //then
        assertThat(arguments.getValue("l"), Is.is(true));
        assertThat(arguments.getValue("d"), Is.is("/usr/logs"));
    }

    @Test
    public void should_true_and_string_value_when_boolean_has_value_boolean_string_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser(
                booleanSchema("false").
                        stringSchema("d", "").build());

        //when
        Arguments arguments = argumentParser.parse("-d  -l true");

        //then
        assertThat(arguments.getValue("l"), Is.is(true));
        assertThat(arguments.getValue("d"), Is.is(""));
    }

    @Test
    public void should_false_and_string_value_when_string_has_value_boolean_string_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser(
                booleanSchema("false").
                        stringSchema("d", "").build());

        //when
        Arguments arguments = argumentParser.parse("-d /test21 -l");

        //then
        assertThat(arguments.getValue("l"), Is.is(false));
        assertThat(arguments.getValue("d"), Is.is("/test21"));
    }

    @Test
    public void should_right_value_when_boolean_integer_string_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser(
                booleanSchema("false").
                        integerSchema("p", "0").
                        stringSchema("d", "").build());

        assertThat(argumentParser.parse("-p 7777 -d /usr/logs23 -l true").getValue("l"), Is.is(true));
        assertThat(argumentParser.parse("-p 7777 -d /usr/logs23 -l true").getValue("d"), Is.is("/usr/logs23"));
        assertThat(argumentParser.parse("-p 7777 -d /usr/logs23 -l true").getValue("p"), Is.is(7777));

        assertThat(argumentParser.parse("-p -d /usr/logs23 -l true").getValue("l"), Is.is(true));
        assertThat(argumentParser.parse("-p -d /usr/logs23 -l true").getValue("d"), Is.is("/usr/logs23"));
        assertThat(argumentParser.parse("-p -d /usr/logs23 -l true").getValue("p"), Is.is(0));

        assertThat(argumentParser.parse("-p -d /usr/logs23 -l").getValue("l"), Is.is(false));
        assertThat(argumentParser.parse("-p -d /usr/logs23 -l").getValue("d"), Is.is("/usr/logs23"));
        assertThat(argumentParser.parse("-p -d /usr/logs23 -l").getValue("p"), Is.is(0));

        assertThat(argumentParser.parse("-p 7777 -d -l").getValue("l"), Is.is(false));
        assertThat(argumentParser.parse("-p 7777 -d -l").getValue("d"), Is.is(""));
        assertThat(argumentParser.parse("-p 7777 -d -l").getValue("p"), Is.is(7777));
    }

    @Test
    public void should_list_string_and_list_integer_when_list_string_and_list_integer_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser(
                listStringSchema("").
                        listIntegerSchema("d", "").build());

        //when
        Arguments arguments = argumentParser.parse("-g this,is,a,list -d 1,2,-3,5,7");
        List<String> strings = arguments.getValue("g");
        List<String> integers = arguments.getValue("d");

        //then
        assertThat(strings.size(), Is.is(4));
        assertThat(integers.size(), Is.is(5));
    }

    private SchemasBuilder listStringSchema(String defaultValue) {
        return SchemasBuilder.builder().listStringSchema("g", defaultValue);
    }

    private SchemasBuilder listIntegerSchema(String defaultValue) {
        return SchemasBuilder.builder().listIntegerSchema("d", defaultValue);
    }

    @Test(expected = DoesNotExistFlagValueException.class)
    public void should_not_found_arg_value_when_get_value_for_not_exist_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser(
                booleanSchema("false").
                        stringSchema("d", "").build());

        //when
        Arguments arguments = argumentParser.parse("-d /test21 -l");

        //then
        assertThat(arguments.getValue("-f"), Is.is("/test21"));
    }

    @Test(expected = DoesNotExistFlagInSchemaException.class)
    public void when_arg_not_match_schema() {
        //given
        ArgumentParser argumentParser = new ArgumentParser(
                booleanSchema("false").
                        stringSchema("d", "").build());

        //when
        Arguments arguments = argumentParser.parse("-f -d /test21 -l -d");

        //then
        assertThat(arguments.getValue("-f"), Is.is("/test21"));
    }
}
