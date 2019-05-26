package com.kata;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sunjing
 */
public final class Turn {

    private int num;

    /**
     * TODO:击中的树提取为对象,封装获取击球树方法
     */
    private List<String> tries = new LinkedList<>();

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String get(int i) {
        return this.tries.get(i);
    }

    public void add(String oneTry) {
        this.tries.add(oneTry);
    }

    public boolean isNormal() {
        if (!isNoTryOne() && !isSpare()&& !isStrike()) {
            return true;
        }
        return false;
    }

    public boolean isStrike() {
        //TODO:标记需要抽象为对象
        return this.tries.get(0).equals("X");
    }

    public boolean isSpare() {
        return this.tries.get(1).equals("/");
    }

    public boolean isNoTryOne() {
        return this.tries.get(0).equals("-") && this.tries.get(1).equals("-");
    }

    public boolean hasOneNoTryOne() {
        return this.isOnTryOneOfFirst() || this.isOnTryOneOfSecond();

    }
    public boolean isOnTryOneOfFirst() {
        return this.tries.get(0).equals("-");
    }

    public boolean isOnTryOneOfSecond() {
        return this.tries.get(1).equals("-");
    }
}
