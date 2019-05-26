package com.kata;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sunjing
 */
public final class Turns {

    private static final int MAX_TURN = 10;

    private List<Turn> turns = new LinkedList<>();

    /**
     * TODO:计算得分的职责不属于Turns
     * @return
     */
    public int totalScore() {
        return getTurns().stream().map(this::scoreOfTurn).reduce(0, Integer::sum);
    }

    public void addTurn(Turn turn) {
        getTurns().add(turn);
        if (turn.getNum() == 0) {
            turn.setNum(getTurns().size());
        }
    }

    private List<Turn> getTurns() {
        return this.turns;
    }

    /**
     * TODO:计算得分的职责需要抽象为对象,此处是过程式处理
     * @param turn
     * @return
     */
    private int scoreOfTurn(Turn turn) {
        if (turn.getNum() > MAX_TURN) {
            return 0;
        }

        if (turn.isNoTryOne()) {
            return 0;
        }

        if (turn.hasOneNoTryOne()) {
            return hasOneNoTryOneOfScore(turn);
        }

        if (turn.isNormal()) {
            return Integer.parseInt(turn.get(0)) + Integer.parseInt(turn.get(1));
        }

        if (turn.isSpare()) {
            return spareOfScore(turn);
        }

        if (turn.isStrike()) {
            return strikeOfScore(turn);
        }

        return 0;
    }

    private Integer hasOneNoTryOneOfScore(Turn turn) {
        if (turn.isOnTryOneOfFirst()) {
            return Integer.parseInt(turn.get(1));
        }

        if (turn.isOnTryOneOfSecond()) {
            return Integer.parseInt(turn.get(0));
        }

        return 0;
    }

    private Integer spareOfScore(Turn turn) {
        if (!turn.isSpare()) {
            return 0;
        }

        Turn next = next(turn);
        if (next.isStrike()) {
            return 10 + 10;
        } else {
            return 10 + Integer.parseInt(next.get(0));
        }
    }

    private Integer strikeOfScore(Turn turn) {
        if (!turn.isStrike()) {
            return null;
        }

        Turn next = next(turn);
        if (next.isStrike()) {
            Turn nextNext = next(next);
            if (nextNext.isStrike()) {
                return 10 + 10 + 10;
            } else {
                return 10 +  10 + Integer.parseInt(nextNext.get(0));
            }
        }

        if (next.isSpare()) {
            return 10 + 10 + 0;
        } else {
            return 10 + Integer.parseInt(next.get(0)) + Integer.parseInt(next.get(1));
        }
    }

    private Turn next(Turn turn) {
        return this.get(turn.getNum());
    }

    private Turn get(int num) {
        return this.turns.get(num);
    }
}
