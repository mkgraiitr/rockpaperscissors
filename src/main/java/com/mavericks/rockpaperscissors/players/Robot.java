package com.mavericks.rockpaperscissors.players;

import com.mavericks.rockpaperscissors.strategy.RandomShapeSelection;

public class Robot extends Player {
    public Robot() {
        setNextMoveStrategy(new RandomShapeSelection());
    }
}
