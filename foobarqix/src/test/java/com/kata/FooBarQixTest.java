package com.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author sunjing
 */
public class FooBarQixTest {

    private FooBarQix fooBarQix;

    @BeforeEach
    public void beforeEach() {
        // given
        fooBarQix = new FooBarQix();
    }

    @Test
    public void should_original_number() {
        assertEquals("1",  fooBarQix.compute("1"));
        assertEquals("2",  fooBarQix.compute("2"));
        assertEquals("4",  fooBarQix.compute("4"));
        assertEquals("8",  fooBarQix.compute("8"));
    }

    @Test
    public void should_Foo_when_is_divisible_3() {
        // when
        String compute = fooBarQix.compute("6");

        // then
        assertEquals("Foo", compute);
    }

    @Test
    public void should_Bar_when_is_divisible_5() {
        assertEquals("Bar", fooBarQix.compute("10"));
    }

    @Test
    public void should_Qix_when_is_divisible_7() {
        assertEquals("Qix", fooBarQix.compute("49"));
    }

    @Test
    public void should_FooFoo_when_is_divisible_3_or_contains_3() {
        assertEquals("FooFoo", fooBarQix.compute("3"));
    }

    @Test
    public void should_BarBar_when_is_divisible_5_or_contains_5() {
        assertEquals("BarBar", fooBarQix.compute("5"));
    }

    @Test
    public void should_QixQix_when_is_divisible_7_or_contains_7() {
        assertEquals("QixQix", fooBarQix.compute("7"));
    }

    @Test
    public void should_FooBarBar_when_is_divisible_3_or_5_or_contains_5() {
        assertEquals("FooBarBar", fooBarQix.compute("15"));
    }

    @Test
    public void should_FooBar_when_is_divisible_3_or_contains_5() {
        assertEquals("FooBar", fooBarQix.compute("51"));
    }

    @Test
    public void should_FooFooFoo_when_is_divisible_3_or_contains_twice_3() {
        assertEquals("FooFooFoo", fooBarQix.compute("33"));
    }

    @Test
    public void should_Foo_when_is_contains_3() {
        assertEquals("Foo", fooBarQix.compute("13"));
    }

    @Test
    public void should_FooFooFoo_when_is_divisible_3_or_7() {
        assertEquals("FooQix", fooBarQix.compute("21"));
    }

    @Test
    public void should_Foo_when_is_contains_3_or_5() {
        assertEquals("FooBar", fooBarQix.compute("53"));
    }
}
