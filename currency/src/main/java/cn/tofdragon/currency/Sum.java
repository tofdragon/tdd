package cn.tofdragon.currency;

/**
 *
 * @author sunjing
 */
public class Sum implements Expression {

    public Expression augend;

    public Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Expression reduce(Bank bank, String to) {
        int amount = ((Money)augend.reduce(bank, to)).amount + ((Money)addend.reduce(bank, to)).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }
}
