package com.mavericks.rockpaperscissors.enums;

public enum Shapes {
    ROCK("ROCK"),
    PAPER("PAPER"),
    SCISSORS("SCISSORS");

    private final String value;

    Shapes(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
