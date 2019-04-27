package cn.tofdragon.currency;

/**
 * @author sunjing
 */
public class Dollar extends Money{

    public Dollar(int amount) {
        this.amount = amount;
    }

    @Override
    public Money times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

}
