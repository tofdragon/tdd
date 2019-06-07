package com.kata;

import java.util.Objects;

/**
 * @author sunjing
 */
final class Unit {

    private int num;

    private String content;

    private Unit() {
    }

    static Unit of(int num, String content) {
        Unit unit = new Unit();
        unit.num = num;
        unit.content = content;
        return unit;
    }

    boolean hasSameContent(Unit unit) {
        return this.content.equals(unit.content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Unit)) {
            return false;
        }
        Unit unit = (Unit) o;
        return num == unit.num &&
                content.equals(unit.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, content);
    }
}
