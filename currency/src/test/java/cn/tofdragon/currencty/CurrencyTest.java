package cn.tofdragon.currencty;

import org.junit.jupiter.api.Test;

import cn.tofdragon.currency.Dollar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 多货币
 *
 * @author sunjing
 */
public class CurrencyTest {

    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);

        Dollar product = five.times(2);
        assertEquals(10, product.amount);

        product = five.times(3);
        assertEquals(15, product.amount);
    }

    @Test
    public void testEquality() {
       assertTrue(new Dollar(5).equals(new Dollar(5)));
       assertFalse(new Dollar(5).equals(new Dollar(6)));
    }
}
