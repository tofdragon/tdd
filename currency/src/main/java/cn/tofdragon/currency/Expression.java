package cn.tofdragon.currency;

/**
 *
 * @author sunjing
 */
public interface Expression {

    Money reduce(String to);
}
