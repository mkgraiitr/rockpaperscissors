package com.mavericks.rockpaperscissors.enums;

import java.util.stream.Stream;

public enum PlayerType {
    HUMAN(1),
    ROBOT(2);

    private final int value;

    PlayerType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static PlayerType getPlayerType(int typeInput){
        return Stream.of(PlayerType.values())
                .filter(playerType -> playerType.value==typeInput)
                .findFirst().get();

    }
}
