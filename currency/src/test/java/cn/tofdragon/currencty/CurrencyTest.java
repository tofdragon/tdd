package cn.tofdragon.currencty;

import org.junit.jupiter.api.Test;

import cn.tofdragon.currency.Dollar;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 多货币
 *
 * @author sunjing
 * @since 0.21.0
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
}
