package cn.tofdragon.currency;

/**
 * @author sunjing
 */
public class Bank {

    public Money reduce(Expression source, String to) {
        return source.reduce(to);
    }
}
