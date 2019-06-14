package com.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 〈功能详细描述〉 描述
 *
 * @author sunjing
 * @since [产品/模块版本]
 */
public class WalletTest {

    @Test
    public void should_1_petroleum() {
        Wallet wallet = new Wallet();
        wallet.addStock(new Stock(1, "petroleum"));

        assertEquals(1, wallet.value("petroleum"));
    }

    @Test
    public void should_10_petroleum() {
        Wallet wallet = new Wallet();
        wallet.addStock(new Stock(1, "petroleum"));
        wallet.addStock(new Stock(2, "petroleum"));
        wallet.addStock(new Stock(7, "petroleum"));

        assertEquals(10, wallet.value("petroleum"));
    }

    @Test
    public void should_10_euros() {
        Wallet wallet = new Wallet();
        wallet.addStock(new Stock(1, "euros"));
        wallet.addStock(new Stock(2, "euros"));
        wallet.addStock(new Stock(7, "euros"));

        assertEquals(10, wallet.value("euros"));
    }

    @Test
    public void should_30_euros_when_petroleum_to_euros() {
        Wallet wallet = new Wallet();
        wallet.addStock(new Stock(10, "petroleum"));
        wallet.addStock(new Stock(10, "euros"));

        assertEquals(30, wallet.value("euros"));
    }

    @Test
    public void should_20_petroleum_when_euros_to_petroleum() {
        Wallet wallet = new Wallet();
        wallet.addStock(new Stock(10, "petroleum"));
        wallet.addStock(new Stock(20, "euros"));

        assertEquals(20, wallet.value("petroleum"));
    }

    @Test
    public void should_40_dollars_when_petroleum_to_dollars() {
        Wallet wallet = new Wallet();
        wallet.addStock(new Stock(10, "petroleum"));
        wallet.addStock(new Stock(10, "dollars"));

        assertEquals(40, wallet.value("dollars"));
    }
}
