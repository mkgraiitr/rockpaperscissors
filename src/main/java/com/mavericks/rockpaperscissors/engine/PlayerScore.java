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
        totalScore += currentRoundScore;
    }

    @Override
    public String toString() {
        return "PlayerScore{" +
                "playerId='" + playerId + '\'' +
                ", totalScore=" + totalScore +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
