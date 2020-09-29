package com.mavericks.rockpaperscissors.engine;

public class PlayerStatistics {
    private String playerId;
    private String playerSelection;
    private int totalScore;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerSelection() {
        return playerSelection;
    }

    public void setPlayerSelection(String playerSelection) {
        this.playerSelection = playerSelection;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void updateTotalScore(int currentRoundScore) {
        totalScore += currentRoundScore;
    }

    @Override
    public String toString() {
        return "Player Id:: " + playerId + " selected -" + playerSelection + " and scored in total:: " + getTotalScore();
    }
}
