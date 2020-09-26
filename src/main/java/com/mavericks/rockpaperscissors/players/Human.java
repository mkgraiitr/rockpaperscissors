package com.mavericks.rockpaperscissors.players;

import com.mavericks.rockpaperscissors.model.CommandLineSelection;

public class Human extends Player {
    public Human() {
       setNextMoveStrategy(new CommandLineSelection());
    }
}
