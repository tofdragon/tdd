package cn.tofdragon.currency;

/**
 * 法郎
 * @author sunjing
 */
public class Franc extends Money{

    public Franc(int amount) {
        this.amount = amount;
    }

    @Override
    public Money times(int multiplier) {
        return new Franc(amount * multiplier);
    }

}
