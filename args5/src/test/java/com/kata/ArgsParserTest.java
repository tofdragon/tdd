package com.kata;

import java.util.List;

import org.hamcrest.core.Is;
import org.junit.Test;
import com.kata.schema.builder.SchemasBuilder;
import com.kata.value.ArgsValues;

import static org.junit.Assert.assertThat;

/**
 * 参数解析测试
 *
 * @author sunjing
 * @since 1.0.0
 */
public final class ArgsParserTest {

    @Test
    public void should_create_args_parser_from_schemas() {
        ArgsParser argsParser = new ArgsParser(SchemasBuilder.builder()
                .booleanSchema("l").stringSchema("p").integerSchema("d").build());

        assertThat(argsParser.sizeOfSchemas(), Is.is(3));
    }

    @Test
    public void should_true_value_when_boolean_schema() {
        ArgsParser argsParser = new ArgsParser(SchemasBuilder.builder().booleanSchema("l").build());

        Boolean value = argsParser.parse("-l true").getValue("l");

        assertThat(value, Is.is(true));
    }

    @Test
    public void should_false_value_when_boolean_schema() {
        ArgsParser argsParser = new ArgsParser(SchemasBuilder.builder()
                .booleanSchema("l").build());

        Boolean value = argsParser.parse("-l false").getValue("l");

        assertThat(value, Is.is(false));
    }

    @Test
    public void should_default_false_value_when_boolean_schema() {
        ArgsParser argsParser = new ArgsParser(SchemasBuilder.builder()
                .booleanSchema("l").build());

        Boolean value = argsParser.parse("-l").getValue("l");

        assertThat(value, Is.is(false));
    }

    @Test
    public void should_default_true_value_when_boolean_schema() {
        ArgsParser argsParser = new ArgsParser(SchemasBuilder.builder()
                .booleanSchema("l", "true").build());

        Boolean value = argsParser.parse("-l").getValue("l");

        assertThat(value, Is.is(true));
    }

    @Test
    public void should_integer_value_when_integer_schema() {
        ArgsParser argsParser = new ArgsParser(
                SchemasBuilder.builder().integerSchema("p").build());

        assertThat(argsParser.parse("-p 8080").getValue("p"), Is.is(8080));
        assertThat(argsParser.parse("-p 7777").getValue("p"), Is.is(7777));
    }

    @Test
    public void should_default_value_when_integer_schema() {
        ArgsParser argsParser = new ArgsParser(SchemasBuilder.builder().integerSchema("p").build());

        assertThat(argsParser.parse("-p").getValue("p"), Is.is(0));
    }

    @Test
    public void should_string_value_when_string_schema() {
        ArgsParser argsParser = new ArgsParser(SchemasBuilder.builder().stringSchema("d").build());

        assertThat(argsParser.parse("-d /usr/logs").getValue("d"), Is.is("/usr/logs"));
        assertThat(argsParser.parse("-d /usr/logs21").getValue("d"), Is.is("/usr/logs21"));
    }

    @Test
    public void should_default_value_when_string_schema() {
        ArgsParser argsParser = new ArgsParser(SchemasBuilder.builder().stringSchema("d").build());

        assertThat(argsParser.parse("-d").getValue("d"), Is.is(""));
    }

    @Test
    public void should_boolean_and_string_schema() {
        ArgsParser argsParser = new ArgsParser(SchemasBuilder.builder()
                .stringSchema("d").booleanSchema("l").build());

        assertThat(argsParser.parse("-l true -d test").getValue("l"), Is.is(true));
        assertThat(argsParser.parse("-l true -d test1").getValue("d"), Is.is("test1"));
        assertThat(argsParser.parse("-l -d test1").getValue("l"), Is.is(false));
        assertThat(argsParser.parse("-l -d test2").getValue("d"), Is.is("test2"));
    }

    @Test
    public void should_default_value_boolean_and_string_schema() {
        ArgsParser argsParser = new ArgsParser(SchemasBuilder.builder()
                .booleanSchema("l").stringSchema("d").build());

        assertThat(argsParser.parse("-l -d").getValue("l"), Is.is(false));
        assertThat(argsParser.parse("-l -d").getValue("d"), Is.is(""));
    }

    @Test
    public void should_boolean_and_string_and_integer_schema() {
        ArgsParser argsParser = new ArgsParser(SchemasBuilder.builder()
                .booleanSchema("l").stringSchema("p").integerSchema("d").build());

        assertThat(argsParser.parse("-l true -p test1 -d 7777").getValue("l"), Is.is(true));
        assertThat(argsParser.parse("-l true -p test1 -d 8888").getValue("p"), Is.is("test1"));
        assertThat(argsParser.parse("-l true -p test1 -d 9999").getValue("d"), Is.is(9999));
    }

    @Test
    public void should_default_value_boolean_and_string_and_integer_schema() {
        ArgsParser argsParser = new ArgsParser(SchemasBuilder.builder()
                .booleanSchema("l").stringSchema("p").integerSchema("d").build());

        assertThat(argsParser.parse("-l -p -d").getValue("l"), Is.is(false));
        assertThat(argsParser.parse("-l -p -d").getValue("p"), Is.is(""));
        assertThat(argsParser.parse("-l -p -d").getValue("d"), Is.is(0));


        assertThat(argsParser.parse("-l -p -d 7777").getValue("l"), Is.is(false));
        assertThat(argsParser.parse("-l -p -d 7777").getValue("p"), Is.is(""));
        assertThat(argsParser.parse("-l -p -d 7777").getValue("d"), Is.is(7777));

        assertThat(argsParser.parse("-l true -p test1 -d").getValue("l"), Is.is(true));
        assertThat(argsParser.parse("-l false -p test1 -d").getValue("p"), Is.is("test1"));
        assertThat(argsParser.parse("-l false -p test1 -d").getValue("d"), Is.is(0));

        assertThat(argsParser.parse("-l true -p -d 8888").getValue("l"), Is.is(true));
        assertThat(argsParser.parse("-l false -p -d 8888").getValue("p"), Is.is(""));
        assertThat(argsParser.parse("-l false -p -d 8888").getValue("d"), Is.is(8888));

        assertThat(argsParser.parse("-l -p test1 -d").getValue("l"), Is.is(false));
        assertThat(argsParser.parse("-l -p test2 -d").getValue("p"), Is.is("test2"));
        assertThat(argsParser.parse("-l -p test3 -d").getValue("d"), Is.is(0));
    }

    @Test
    public void should_list_value_when_string_list_schema() {
        ArgsParser argsParser = new ArgsParser(SchemasBuilder.builder()
                .listStringSchema("g").listIntegerSchema("d").build());

        ArgsValues argsValues = argsParser.parse("-g this,is,a,list -d 1,2,-3,5,7");

        List<String> stringValues = argsValues.getValue("g");
        List<Integer> integerValues = argsValues.getValue("d");

        assertThat(stringValues.size(), Is.is(4));
        assertThat(integerValues.size(), Is.is(5));
    }

}
