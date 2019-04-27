package cn.tofdragon.currency;

/**
 *
 * @author sunjing
 */
public class Money {

    protected int amount;

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return amount == money.amount && getClass().equals(obj.getClass());
    }
}
