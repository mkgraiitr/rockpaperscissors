package com.mavericks.rockpaperscissors.players;

import com.mavericks.rockpaperscissors.strategy.CommandLineSelection;

import java.util.Scanner;

public class Human extends Player {
    private String id;
    private String name;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Human(String id, String name, Scanner scanner) {
        this.id = id;
        this.name = name;
        setNextMoveStrategy(new CommandLineSelection(scanner));
    }
}
