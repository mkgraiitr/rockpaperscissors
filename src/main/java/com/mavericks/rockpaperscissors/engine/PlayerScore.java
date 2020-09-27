package com.mavericks.rockpaperscissors.engine;

public class PlayerScore {
    private String playerId;
    private int updatedScore;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getUpdatedScore() {
        return updatedScore;
    }

    public void setUpdatedScore(int updatedScore) {
        this.updatedScore = updatedScore;
    }
}
