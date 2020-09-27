package com.mavericks.rockpaperscissors.players;

import com.mavericks.rockpaperscissors.strategy.CommandLineSelection;


public class Human extends Player {
    public Human() {
       setNextMoveStrategy(new CommandLineSelection());
    }
}
