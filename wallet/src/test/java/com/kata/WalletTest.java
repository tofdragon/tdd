package com.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author sunjing
 */
public class WalletTest {

    private Wallet wallet;
    
    @BeforeEach
    public void beforeEach() {
        wallet = new Wallet();
    }

    @Test
    public void should_1_petroleum() {
        wallet.addStock(Stock.of(1, "petroleum"));

        assertEquals(1, wallet.value("petroleum"));
    }

    @Test
    public void should_10_petroleum() {
        wallet.addStock(Stock.of(1, "petroleum"));
        wallet.addStock(Stock.of(2, "petroleum"));
        wallet.addStock(Stock.of(7, "petroleum"));

        assertEquals(10, wallet.value("petroleum"));
    }

    @Test
    public void should_10_euros() {
        Wallet wallet = new Wallet();
        wallet.addStock(Stock.of(1, "euros"));
        wallet.addStock(Stock.of(2, "euros"));
        wallet.addStock(Stock.of(7, "euros"));

        assertEquals(10, wallet.value("euros"));
    }

    @Test
    public void should_30_euros_when_petroleum_to_euros() {
        Wallet wallet = new Wallet();
        wallet.addStock(Stock.of(10, "petroleum"));
        wallet.addStock(Stock.of(10, "euros"));

        assertEquals(30, wallet.value("euros"));
    }

    @Test
    public void should_40_dollars_when_petroleum_to_dollars() {
        Wallet wallet = new Wallet();
        wallet.addStock(Stock.of(10, "petroleum"));
        wallet.addStock(Stock.of(10, "dollars"));

        assertEquals(40, wallet.value("dollars"));
    }

    @Test
    public void should_20_petroleum_when_euros_to_petroleum() {
        Wallet wallet = new Wallet();
        wallet.addStock(Stock.of(10, "petroleum"));
        wallet.addStock(Stock.of(40, "euros"));

        assertEquals(30, wallet.value("petroleum"));
    }
}
