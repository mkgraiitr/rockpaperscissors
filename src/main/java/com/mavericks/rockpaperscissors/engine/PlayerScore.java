package com.mavericks.rockpaperscissors.engine;

public class PlayerScore {
    private String playerId;
    private int totalScore;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void updateTotalScore(int currentRoundScore) {
        totalScore+=currentRoundScore;
    }
}
