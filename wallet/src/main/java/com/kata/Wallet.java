package com.kata;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjing
 */
public final class Wallet {

    private List<Stock> stocks = new ArrayList<>();

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double value(String toCurrency) {
        return stocks.stream().mapToDouble(
                stock -> stock.getQuantity() * RateProvider.rate(stock.getType(), toCurrency)).sum();
    }
}
