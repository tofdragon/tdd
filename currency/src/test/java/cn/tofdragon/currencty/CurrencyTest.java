package cn.tofdragon.currencty;

import org.junit.jupiter.api.Test;

import cn.tofdragon.currency.Dollar;
import cn.tofdragon.currency.Franc;

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

        assertEquals(new Dollar(10), five.times(2));
        assertEquals(new Dollar(15), five.times(3));
    }

    @Test
    public void testEquality() {
       assertTrue(new Dollar(5).equals(new Dollar(5)));
       assertFalse(new Dollar(5).equals(new Dollar(6)));

        assertTrue(new Franc(5).equals(new Franc(5)));
        assertFalse(new Franc(5).equals(new Franc(6)));
    }

    @Test
    public void festFrancMultiplication(){
        Franc five = new Franc(5);

        assertEquals(new Franc(10), five.times(2));
        assertEquals(new Franc(15), five.times(3));
    }
}
