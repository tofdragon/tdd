package com.kata;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author sunjing
 */
final class RateProvider {

    private static Map<Pair, Double> pairToRate = new HashMap<>();

    static {
        pairToRate.put(new Pair("petroleum", "euros"), 2d);
        pairToRate.put(new Pair("euros", "petroleum"), 1/2d);
        pairToRate.put(new Pair("petroleum", "dollars"), 3d);
        pairToRate.put(new Pair("dollars", "petroleum"), 1/3d);
    }

    static double rate(String fromCurrency, String toCurrency) {
        return fromCurrency.equals(toCurrency) ? 1 : pairToRate.get(new Pair(fromCurrency, toCurrency));
    }

    private static class Pair {

        private String from;

        private String to;

        Pair(String from, String to) {
            this.from = from;
            this.to = to;
        }

        String getFrom() {
            return from;
        }

        String getTo() {
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
