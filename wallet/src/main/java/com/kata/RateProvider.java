package com.kata;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author sunjing
 */
public final class RateProvider {

    private static Map<Pair, Integer> pairToRate = new HashMap<>();

    static {
        pairToRate.put(new Pair("petroleum", "euros"), 2);
        pairToRate.put(new Pair("euros", "petroleum"), 1/2);
        pairToRate.put(new Pair("petroleum", "dollars"), 3);
        pairToRate.put(new Pair("dollars", "petroleum"), 1/3);
    }

    public static int rate(Stock from, String toCurrency) {
        if (from.getType().equals(toCurrency)) {
            return from.getAmount();
        }
        int rate = pairToRate.get(new Pair(from.getType(), toCurrency));
        return from.getAmount() * rate;
    }

    private static class Pair {

        private String from;

        private String to;

        public Pair(String from, String to) {
            this.from = from;
            this.to = to;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair pair = (Pair) o;
            return getFrom().equals(pair.getFrom()) &&
                    getTo().equals(pair.getTo());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getFrom(), getTo());
        }
    }
}
