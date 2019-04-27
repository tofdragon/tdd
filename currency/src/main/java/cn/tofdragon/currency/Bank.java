package cn.tofdragon.currency;

import java.util.Hashtable;

/**
 * @author sunjing
 */
public class Bank {

    private Hashtable<Pair, Integer> rates = new Hashtable<>();
    
    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    public int rate(String from, String to) {
        if (from.equals(to)) {
            return 1;
        }
        return rates.get(new Pair(from, to)).intValue();
    }

    public void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), rate);
    }
}
