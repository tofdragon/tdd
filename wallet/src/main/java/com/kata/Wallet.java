package com.kata;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能详细描述〉 描述
 *
 * @author sunjing
 * @since [产品/模块版本]
 */
public class Wallet {

    private List<Stock> stocks = new ArrayList<>();

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public int value(String currency) {
        int total = 0;
        for (Stock stock : stocks) {

            if (currency.equals("euros")) {
                total += RateProvider.rate(stock, "euros");
            }

            if (currency.equals("petroleum")) {
                total += RateProvider.rate(stock, "petroleum");
            }

            if (currency.equals("dollars")) {
                total += RateProvider.rate(stock, "dollars");
            }

        }
        return total;
    }
}
