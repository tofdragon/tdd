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
                if (stock.getType().equals("petroleum")) {
                    total += stock.getAmount() * 2;
                } else if (stock.getType().equals("euros")) {
                    total += stock.getAmount();
                }
            }

            if (currency.equals("petroleum")) {
                if (stock.getType().equals("euros")) {
                    total += stock.getAmount() /2;
                } else if (stock.getType().equals("petroleum")) {
                    total += stock.getAmount();
                }
            }

            if (currency.equals("dollars")) {
                if (stock.getType().equals("petroleum")) {
                    total += stock.getAmount() * 3;
                } else if (stock.getType().equals("dollars")) {
                    total += stock.getAmount();
                }
            }

        }
        return total;
    }
}
