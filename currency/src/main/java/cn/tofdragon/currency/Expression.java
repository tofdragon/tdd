package cn.tofdragon.currency;

/**
 *
 * @author sunjing
 */
public interface Expression {

    Money reduce(Bank bank, String to);
}
