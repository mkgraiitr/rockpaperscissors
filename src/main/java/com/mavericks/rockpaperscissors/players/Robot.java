package com.mavericks.rockpaperscissors.players;

import com.mavericks.rockpaperscissors.model.RandomShapeSelection;

public class Robot extends Player {
    public Robot() {
        setNextMoveStrategy(new RandomShapeSelection());
    }
}
