/**
 * @author sunjing
 */
public final class FizzBuzz {

    public boolean isFizz(int number) {
        if (isDivisibleByThree(number)) {
            return true;
        }

        if (isIncludeThree(number)) {
            return true;
        }

        return false;
    }

    private boolean isDivisibleByThree(int number) {
        return number % 3 == 0 ? true : false;
    }

    private boolean isIncludeThree(int number) {
        return String.valueOf(number).indexOf("3") > -1 ? true : false;
    }

    public boolean isBuzz(int number) {
        if (isDivisibleByFive(number)) {
            return true;
        }

        if (isIncludeFive(number)) {
            return true;
        }

        return false;
    }

    private boolean isIncludeFive(int number) {
        return String.valueOf(number).indexOf("5") > -1 ? true : false;
    }

    private boolean isDivisibleByFive(int number) {
        return number % 5 == 0 ? true : false;
    }

    public boolean isFizzBuzz(int number) {
        return isDivisibleByThree(number) && isDivisibleByFive(number);
    }
}
