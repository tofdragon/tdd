package cn.tofdragon.currency;

/**
 *
 * @author sunjing
 */
public interface Expression {

    Expression reduce(Bank bank, String to);

    Expression times(int multiplier);

    Expression plus(Expression five);
}
