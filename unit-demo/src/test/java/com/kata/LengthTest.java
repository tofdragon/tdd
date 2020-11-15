package com.kata;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author sunjing
 */
public class LengthTest {

    @Test
    public void should_create_1_inch() {
        Length inch = new Length(1, "Inch");
    }

    @Test
    public void should_1_inch_equals_to_1_inch() {
        Length inch = new Length(1, "Inch");
        assertThat(inch, is(new Length(1, "Inch")));
    }

    @Test
    public void should_display_friendly() {
        assertThat(new Length(1, "Inch").toString(), is("1 (Inch)"));
        assertThat(new Length(1, "Foot").toString(), is("1 (Foot)"));
        assertThat(new Length(1, "Inch").toString(), is("1 (Inch)"));

    }

    @Test
    public void should_1_foot_equals_to_12_inch() {
        assertThat(new Length(1, "Foot"), is(new Length(12, "Inch")));
    }

    @Test
    public void should_1_yard_equals_to_3_foot() {
        assertThat(new Length(1, "Yard"), is(new Length(3, "Foot")));
    }
}
