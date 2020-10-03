package com.mavericks.rockpaperscissors.players;

import com.mavericks.rockpaperscissors.strategy.RandomShapeSelection;

public class Robot extends Player {
    public String id;
    public String name;

    public Robot(String id, String name) {
        this.id = id;
        this.name = name;
        setNextMoveStrategy(new RandomShapeSelection());
    }

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
}
