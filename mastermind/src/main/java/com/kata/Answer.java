package com.kata;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sunjing
 */
public final class Answer {

    private List<Unit> units = new LinkedList<>();

    private Answer() {
    }

    public static Answer of(String content) {
        Answer answer = new Answer();

        String[] units = content.split(",");
        for (int i = 0; i < units.length; i++) {
            answer.addUnit(Unit.of(i, units[i]));
        }

        return answer;
    }

    public int wellPlaced(Answer answer) {
        int wellPlaced = 0;
        for (int i = 0; i < getUnits().size(); i++) {
            Unit foundUnit = answer.findUnit(getUnits().get(i));
            if (foundUnit != null && foundUnit.equals(getUnits().get(i))) {
                wellPlaced ++;
            }
        }
        return wellPlaced;
    }

    public int misPlaced(Answer answer) {
        int misPlaced = 0;
        for (int i = 0; i < this.getUnits().size(); i++) {
            Unit foundUnit = answer.findUnit(this.getUnits().get(i));
            if (foundUnit != null && !foundUnit.equals(getUnits().get(i))) {
                misPlaced ++;
            }
        }
        return misPlaced;
    }

    public Unit findUnit(Unit unit) {
        return getUnits().stream()
                .filter(unit1 -> unit1.getContent().equals(unit.getContent()))
                .findAny()
                .orElse(null);
    }

    private List<Unit> getUnits() {
        return units;
    }

    private void addUnit(Unit unit) {
        this.units.add(unit);
    }
}
