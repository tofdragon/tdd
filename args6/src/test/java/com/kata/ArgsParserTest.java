package com.kata;

import org.hamcrest.core.Is;
import org.junit.Test;
import com.google.common.collect.Lists;
import com.kata.exception.DoesNotExistFlagInSchemaException;
import com.kata.exception.DoesNotExistFlagValueException;

import static org.junit.Assert.assertThat;

/**
 * @author sunjing
 */
public class ArgsParserTest {

    @Test
    public void should_false_default_value_when_boolean_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(booleanSchema("false")));

        //when
        ArgsValue argsValue = argsParser.parse("-l");

        //then
        assertThat(argsValue.getBoolean("l"), Is.is(false));
    }

    private Schema booleanSchema(String defaultValue) {
        return new Schema("l", "Boolean", defaultValue);
    }

    @Test
    public void should_true_default_value_when_boolean_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(booleanSchema("true")));

        //when
        ArgsValue argsValue = argsParser.parse("-l");

        //then
        assertThat(argsValue.getBoolean("l"), Is.is(true));
    }

    @Test
    public void should_0_default_value_when_integer_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(integerSchema("0")));

        //when
        ArgsValue argsValue = argsParser.parse("-p");

        //then
        assertThat(argsValue.getInteger("p"), Is.is(0));
    }

    private Schema integerSchema(String defaultValue) {
        return new Schema("p", "Integer", defaultValue);
    }

    @Test
    public void should_8080_default_value_when_integer_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(integerSchema("8080")));

        //when
        ArgsValue argsValue = argsParser.parse("-p");

        //then
        assertThat(argsValue.getInteger("p"), Is.is(8080));
    }

    @Test
    public void should_white_default_value_when_string_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(stringSchema("")));

        //when
        ArgsValue argsValue = argsParser.parse("-d");

        //then
        assertThat(argsValue.getString("d"), Is.is(""));
    }

    private Schema stringSchema(String defaultValue) {
        return new Schema("d", "String", defaultValue);
    }

    @Test
    public void should_test_default_value_when_string_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(stringSchema("test")));

        //when
        ArgsValue argsValue = argsParser.parse("-d");

        //then
        assertThat(argsValue.getString("d"), Is.is("test"));
    }

    @Test
    public void should_true_when_has_value_and_boolean_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(booleanSchema("false")));

        //when
        ArgsValue argsValue = argsParser.parse("-l true");

        //then
        assertThat(argsValue.getBoolean("l"), Is.is(true));
    }

    @Test
    public void should_false_when_has_value_and_boolean_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(booleanSchema("true")));

        //when
        ArgsValue argsValue = argsParser.parse("-l false");

        //then
        assertThat(argsValue.getBoolean("l"), Is.is(false));
    }

    @Test
    public void should_8080_when_has_value_integer_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(integerSchema("0")));

        //when
        ArgsValue argsValue = argsParser.parse("-p 8080");

        //then
        assertThat(argsValue.getInteger("p"), Is.is(8080));
    }

    @Test
    public void should_test21_when_has_value_string_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(stringSchema("")));

        //when
        ArgsValue argsValue = argsParser.parse("-d test21");

        //then
        assertThat(argsValue.getString("d"), Is.is("test21"));
    }

    @Test
    public void should_default_value_when_boolean_string_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(
                booleanSchema("false"),
                stringSchema("0")));

        //when
        ArgsValue argsValue = argsParser.parse("-l -d");

        //then
        assertThat(argsValue.getBoolean("l"), Is.is(false));
        assertThat(argsValue.getString("d"), Is.is("0"));
    }

    @Test
    public void should_default_value_when_integer_string_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(
                integerSchema("9999"),
                stringSchema("test21")));

        //when
        ArgsValue argsValue = argsParser.parse("-p -d");

        //then
        assertThat(argsValue.getInteger("p"), Is.is(9999));
        assertThat(argsValue.getString("d"), Is.is("test21"));
    }

    @Test
    public void should_default_value_when_boolean_integer_string_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(
                booleanSchema("false"),
                integerSchema("9999"),
                stringSchema("test21")));

        //when
        ArgsValue argsValue = argsParser.parse("-p -d -l");

        //then
        assertThat(argsValue.getBoolean("l"), Is.is(false));
        assertThat(argsValue.getInteger("p"), Is.is(9999));
        assertThat(argsValue.getString("d"), Is.is("test21"));
    }

    @Test
    public void should_true_and_string_value_when_has_value_boolean_string_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(
                booleanSchema("false"),
                stringSchema("")));

        //when
        ArgsValue argsValue = argsParser.parse("-d /usr/logs -l true");

        //then
        assertThat(argsValue.getBoolean("l"), Is.is(true));
        assertThat(argsValue.getString("d"), Is.is("/usr/logs"));
    }

    @Test
    public void should_true_and_string_value_when_boolean_has_value_boolean_string_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(
                booleanSchema("false"),
                stringSchema("")));

        //when
        ArgsValue argsValue = argsParser.parse("-d  -l true");

        //then
        assertThat(argsValue.getBoolean("l"), Is.is(true));
        assertThat(argsValue.getString("d"), Is.is(""));
    }

    @Test
    public void should_false_and_string_value_when_string_has_value_boolean_string_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(
                booleanSchema("false"),
                stringSchema("")));

        //when
        ArgsValue argsValue = argsParser.parse("-d /test21 -l");

        //then
        assertThat(argsValue.getBoolean("l"), Is.is(false));
        assertThat(argsValue.getString("d"), Is.is("/test21"));
    }

    @Test
    public void should_right_value_when_boolean_integer_string_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(
                booleanSchema("false"),
                integerSchema("0"),
                stringSchema("")));

        assertThat(argsParser.parse("-p 7777 -d /usr/logs23 -l true").getBoolean("l"), Is.is(true));
        assertThat(argsParser.parse("-p 7777 -d /usr/logs23 -l true").getString("d"), Is.is("/usr/logs23"));
        assertThat(argsParser.parse("-p 7777 -d /usr/logs23 -l true").getInteger("p"), Is.is(7777));

        assertThat(argsParser.parse("-p -d /usr/logs23 -l true").getBoolean("l"), Is.is(true));
        assertThat(argsParser.parse("-p -d /usr/logs23 -l true").getString("d"), Is.is("/usr/logs23"));
        assertThat(argsParser.parse("-p -d /usr/logs23 -l true").getInteger("p"), Is.is(0));

        assertThat(argsParser.parse("-p -d /usr/logs23 -l").getBoolean("l"), Is.is(false));
        assertThat(argsParser.parse("-p -d /usr/logs23 -l").getString("d"), Is.is("/usr/logs23"));
        assertThat(argsParser.parse("-p -d /usr/logs23 -l").getInteger("p"), Is.is(0));

        assertThat(argsParser.parse("-p 7777 -d -l").getBoolean("l"), Is.is(false));
        assertThat(argsParser.parse("-p 7777 -d -l").getString("d"), Is.is(""));
        assertThat(argsParser.parse("-p 7777 -d -l").getInteger("p"), Is.is(7777));
    }

    @Test
    public void should_list_string_and_list_integer_when_list_string_and_list_integer_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(
                listStringSchema(""),
                listIntegerSchema("")));

        //when
        ArgsValue argsValue = argsParser.parse("-g this,is,a,list -d 1,2,-3,5,7");

        //then
        assertThat(argsValue.getListString("g").size(), Is.is(4));
        assertThat(argsValue.getListInteger("d").size(), Is.is(5));
    }

    private Schema listStringSchema(String defaultValue) {
        return new Schema("g", "ListString", defaultValue);
    }

    private Schema listIntegerSchema(String defaultValue) {
        return new Schema("d", "ListInteger", defaultValue);
    }

    @Test(expected = DoesNotExistFlagValueException.class)
    public void should_not_found_arg_value_when_get_value_for_not_exist_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(
                booleanSchema("false"),
                stringSchema("")));

        //when
        ArgsValue argsValue = argsParser.parse("-d /test21 -l");

        //then
        assertThat(argsValue.getString("-f"), Is.is("/test21"));
    }

    @Test(expected = DoesNotExistFlagInSchemaException.class)
    public void when_arg_not_match_schema() {
        //given
        ArgsParser argsParser = new ArgsParser(Lists.newArrayList(
                booleanSchema("false"),
                stringSchema("")));

        //when
        ArgsValue argsValue = argsParser.parse("-f -d /test21 -l -d");

        //then
        assertThat(argsValue.getString("-f"), Is.is("/test21"));
    }
}
