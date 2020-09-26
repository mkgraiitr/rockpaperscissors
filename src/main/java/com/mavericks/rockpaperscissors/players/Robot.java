package com.mavericks.rockpaperscissors.players;

import com.mavericks.rockpaperscissors.model.RandomShapeSelection;
import lombok.*;

public class Robot extends Player {
    public Robot() {
        setNextMoveStrategy(new RandomShapeSelection());
    }
}
