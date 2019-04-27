package cn.tofdragon.currency;

/**
 *
 * @author sunjing
 */
public class Sum implements Expression {

    public Money augend;

    public Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Money reduce(String to) {
        int amount = addend.amount + augend.amount;
        return new Money(amount, to);
    }
}
