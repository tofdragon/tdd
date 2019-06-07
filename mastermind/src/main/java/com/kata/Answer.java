package com.kata;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunjing
 */
final class Answer {

    private List<Unit> units = new LinkedList<>();

    private Answer() {
    }

    static Answer of(String content) {
        Answer answer = new Answer();

        String[] units = content.split(",");
        for (int num = 0; num < units.length; num++) {
            answer.addUnit(Unit.of(num, units[num]));
        }
        return answer;
    }

    Unit findUnit(Unit compareUnit) {
        return units().stream()
                .filter(unit -> unit.hasSameContent(compareUnit))
                .findAny()
                .orElse(null);
    }

    List<Unit> units() {
        return Collections.unmodifiableList(units);
    }

    private void addUnit(Unit unit) {
        this.units.add(unit);
    }
}
