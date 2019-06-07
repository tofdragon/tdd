package com.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author sunjing
 */
public class LeapYearTest {

    @Test
    public void should_is_leap_year_when_is_divisible_400() {
        LeapYear leapYear = new LeapYear();

        assertTrue(leapYear.is("2000"));
    }

    @Test
    public void should_is_not_leap_year_when_is_divisible_4() {
        LeapYear leapYear = new LeapYear();

        assertFalse(leapYear.is("2017"));
        assertFalse(leapYear.is("2018"));
        assertFalse(leapYear.is("2019"));
    }

    @Test
    public void should_is_not_leap_year_when_is_divisible_100_not_divisible_400() {
        LeapYear leapYear = new LeapYear();

        assertFalse(leapYear.is("1700"));
        assertFalse(leapYear.is("1800"));
        assertFalse(leapYear.is("1900"));
        assertFalse(leapYear.is("2100"));
    }

    @Test
    public void should_is_leap_year_when_is_divisible_4_not_divisible_100() {
        LeapYear leapYear = new LeapYear();

        assertTrue(leapYear.is("2008"));
        assertTrue(leapYear.is("2012"));
        assertTrue(leapYear.is("2016"));
    }

}
