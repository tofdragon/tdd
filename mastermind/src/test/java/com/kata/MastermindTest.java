package com.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 〈功能详细描述〉 描述
 *
 * @author sunjing
 * @since [产品/模块版本]
 */
public class MastermindTest {

    @Test
    public void should_0_0_when_all_not_right() {
        Mastermind mastermind = new Mastermind();

        assertEquals("0,0", mastermind.evaluate("blue", "red"));
    }

    @Test
    public void should_1_0_when_one_wellPlaced() {
        Mastermind mastermind = new Mastermind();

        assertEquals("1,0", mastermind.evaluate("blue", "blue"));
    }

    @Test
    public void should_all_wellPlaced_when_multiple_secret() {
        Mastermind mastermind = new Mastermind();

        assertEquals("2,0", mastermind.evaluate("blue,red", "blue,red"));
        assertEquals("3,0", mastermind.evaluate("blue,red,green", "blue,red,green"));
        assertEquals("4,0", mastermind.evaluate("blue,red,green,pink", "blue,red,green,pink"));
    }

    @Test
    public void should_all_misplaced_when_misplaced() {
        Mastermind mastermind = new Mastermind();

        assertEquals("0,2", mastermind.evaluate("blue,red", "red,blue"));
        assertEquals("0,3", mastermind.evaluate("blue,red,green", "green,blue,red"));

    }

    @Test
    public void should_1_0_when_one_wellPlaced_of_two_length_secret() {
        Mastermind mastermind = new Mastermind();

        assertEquals("1,0", mastermind.evaluate("blue,red", "blue,green"));
    }

    @Test
    public void should_0_1_when_one_misplaced_of_two_length_secret() {
        Mastermind mastermind = new Mastermind();

        assertEquals("0,1", mastermind.evaluate("blue,red", "green,blue"));
    }

    @Test
    public void should_all_not_right_when_multiple() {
        Mastermind mastermind = new Mastermind();

        assertEquals("0,0", mastermind.evaluate("blue,red", "green,pink"));
        assertEquals("0,0", mastermind.evaluate("blue,red,green", "yellow,pink,purple"));
    }

    @Test
    public void should_1_1() {
        Mastermind mastermind = new Mastermind();

        assertEquals("1,1", mastermind.evaluate("blue,red,green", "yellow,red,blue"));
        assertEquals("1,1", mastermind.evaluate("blue,red,green,pink", "yellow,red,blue,purple"));

    }

    @Test
    public void should_2_0() {
        Mastermind mastermind = new Mastermind();

        assertEquals("2,0", mastermind.evaluate("blue,red,green", "blue,red,pink"));

    }
}
