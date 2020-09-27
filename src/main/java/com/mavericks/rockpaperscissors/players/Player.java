package com.mavericks.rockpaperscissors.players;

import com.mavericks.rockpaperscissors.strategy.NextMoveStrategy;

public class Player {
    private String playerId;
    private String playerName;
    private NextMoveStrategy nextMoveStrategy;

    public void setNextMoveStrategy(NextMoveStrategy nextMoveStrategy) {
        this.nextMoveStrategy = nextMoveStrategy;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerMove() {
        return nextMoveStrategy.makeMove();
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return playerId;
    }


    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return " player '" + playerName + '\'' +
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
