package com.mavericks.rockpaperscissors.players;

import com.mavericks.rockpaperscissors.strategy.NextMoveStrategy;

public class Player {
    private String id;
    private String name;
    private NextMoveStrategy nextMoveStrategy;

    public void setNextMoveStrategy(NextMoveStrategy nextMoveStrategy) {
        this.nextMoveStrategy = nextMoveStrategy;
    }

    public String getName() {
        return name;
    }

    public String getPlayerMove() {
        return nextMoveStrategy.makeMove();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " player '" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
