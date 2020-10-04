package com.mavericks.rockpaperscissors.enums;

import java.util.stream.Stream;

public enum Type {
    HUMAN(1),
    ROBOT(2);

    private final int value;

    Type(int value) {
        this.value = value;
    }

    public static Type getPlayerType(int typeInput) {
        return Stream.of(Type.values())
                .filter(type -> type.value == typeInput)
                .findFirst().get();

    }

    public int getValue() {
        return this.value;
    }
}
