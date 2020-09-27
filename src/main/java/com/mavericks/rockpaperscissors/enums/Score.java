package com.mavericks.rockpaperscissors.enums;

public enum Score {
    WIN(1),
    LOSE(-1),
    DRAW(0),
    WINNING_SCORE(5);

    private final int value;

    Score(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
