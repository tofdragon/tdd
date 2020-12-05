package com.kata;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author sunjing
 */
public class LengthTest {

    @Test
    public void should_create_inch() {
        Length inch = new Length(1, Unit.Inch);
        assertThat(inch, is(new Length(1, Unit.Inch)));
    }

    @Test
    public void should_display_friendly() {
        assertThat(new Length(1, Unit.Inch).toString(), is("1 (Inch)"));
        assertThat(new Length(1, Unit.Foot).toString(), is("1 (Foot)"));
        assertThat(new Length(1, Unit.Yard).toString(), is("1 (Yard)"));
    }

    @Test
    public void should_create_foot() {
        Length inch = new Length(1, Unit.Foot);
        assertThat(inch, is(new Length(1, Unit.Foot)));
    }

    @Test
    public void should_1_foot_equals_12_inch() {
        assertThat(new Length(1, Unit.Foot), is(new Length(12, Unit.Inch)));
    }

    @Test
    public void should_create_yard() {
        Length inch = new Length(1, Unit.Yard);
        assertThat(inch, is(new Length(1, Unit.Yard)));
    }

    @Test
    public void should_1_yard_equals_36_inch() {
        assertThat(new Length(1, Unit.Yard), is(new Length(36, Unit.Inch)));
        assertThat(new Length(1, Unit.Yard), is(new Length(3, Unit.Foot)));
    }
}
