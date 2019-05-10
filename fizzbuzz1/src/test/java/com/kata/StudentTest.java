package com.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    @Test
    public void should_say_fizz_when_divisible_by_three() {
        Student student = new Student();
        assertEquals(Answer.FIZZ.getAnswer(), student.say(3));
        assertEquals(Answer.FIZZ.getAnswer(), student.say(6));
        assertEquals(Answer.FIZZ.getAnswer(), student.say(21));
    }

    @Test
    public void should_say_buzz_when_divisible_by_five() {
        Student student = new Student();
        assertEquals(Answer.BUZZ.getAnswer(), student.say(5));
        assertEquals(Answer.BUZZ.getAnswer(), student.say(25));
        assertEquals(Answer.BUZZ.getAnswer(), student.say(50));
    }

    @Test
    public void should_say_fizz_and_buzz_when_divisible_by_three_and_five() {
        Student student = new Student();
        assertEquals(Answer.FIZZ_BUZZ.getAnswer(), student.say(15));
        assertEquals(Answer.FIZZ_BUZZ.getAnswer(), student.say(51));
        assertEquals(Answer.FIZZ_BUZZ.getAnswer(), student.say(60));
    }

    @Test
    public void should_say_fizz_when_include_three() {
        Student student = new Student();
        assertEquals(Answer.FIZZ.getAnswer(), student.say(13));
        assertEquals(Answer.FIZZ.getAnswer(), student.say(23));
    }

    @Test
    public void should_say_fizz_when_include_five() {
        Student student = new Student();
        assertEquals(Answer.BUZZ.getAnswer(), student.say(55));
    }

    @Test
    public void should_say_original_number_when_is_not_fizz_or_buzz_or_fizzbuzz() {
        Student student = new Student();
        assertEquals("1", student.say(1));
        assertEquals("2", student.say(2));
    }
}
