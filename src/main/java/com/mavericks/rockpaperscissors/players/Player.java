package com.mavericks.rockpaperscissors.players;

import com.mavericks.rockpaperscissors.model.NextMoveStrategy;

public class Player {
    private String playerId;
    private String playerName;
    private int totalScore;
    private NextMoveStrategy nextMoveStrategy;

    public void updateScore(int currentRoundScore) {
        totalScore += currentRoundScore;
    }

    public void setNextMoveStrategy(NextMoveStrategy nextMoveStrategy) {
        this.nextMoveStrategy = nextMoveStrategy;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerMove(){
        return nextMoveStrategy.makeMove();
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return "Player{" +
                " playerName = '" + playerName + '\'' +
                ", totalScore = " + totalScore +
                '}';
    }

}
