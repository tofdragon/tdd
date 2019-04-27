package cn.tofdragon.currency;

/**
 * 法郎
 * @author sunjing
 */
public class Franc extends Money{

    public Franc(int amount, String currency) {
        super(amount, currency);
    }

    @Override
    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }


}
