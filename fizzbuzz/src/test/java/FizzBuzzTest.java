import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author sunjing
 */
public class FizzBuzzTest {

    @Test
    public void should_fizz_when_divisible_by_three() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        Assertions.assertTrue(fizzBuzz.isFizz(3));
        Assertions.assertTrue(fizzBuzz.isFizz(6));
        Assertions.assertTrue(fizzBuzz.isFizz(9));
        Assertions.assertTrue(fizzBuzz.isFizz(12));
    }

    @Test
    public void should_not_fizz_when_not_divisible_by_three() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        Assertions.assertFalse(fizzBuzz.isFizz(5));
        Assertions.assertFalse(fizzBuzz.isFizz(22));
        Assertions.assertFalse(fizzBuzz.isFizz(25));
    }

    @Test
    public void should_buzz_when_divisible_by_five() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        Assertions.assertTrue(fizzBuzz.isBuzz(5));
        Assertions.assertTrue(fizzBuzz.isBuzz(25));
        Assertions.assertTrue(fizzBuzz.isBuzz(55));
    }

    @Test
    public void should_not_buzz_when_not_divisible_by_five() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        Assertions.assertFalse(fizzBuzz.isBuzz(6));
        Assertions.assertFalse(fizzBuzz.isBuzz(21));
    }

    @Test
    public void should_fizz_and_buzz_when_divisible_by_three_and_five() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        Assertions.assertTrue(fizzBuzz.isFizzBuzz(15));
    }

    @Test
    public void should_not_fizz_and_buzz_when_not_divisible_by_three_and_five() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        Assertions.assertFalse(fizzBuzz.isFizzBuzz(16));
    }

    @Test
    public void should_fizz_when_include_three() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        Assertions.assertTrue(fizzBuzz.isFizz(13));
        Assertions.assertTrue(fizzBuzz.isFizz(23));
    }

    @Test
    public void should_buzz_when_include_five() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        Assertions.assertTrue(fizzBuzz.isBuzz(52));
        Assertions.assertTrue(fizzBuzz.isBuzz(15));
    }

}
