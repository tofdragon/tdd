package com.kata;

/**
 * @author sunjing
 */
public final class Stock {

    private int quantity;

    private String type;

    private Stock(){
    }

    public static Stock of(int quantity, String type) {
        Stock stock = new Stock();
        stock.quantity = quantity;
        stock.type = type;
        return stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }
}
