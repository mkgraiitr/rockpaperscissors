package com.mavericks.rockpaperscissors.engine;

public class PlayerSelection {
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

    private String playerId;
    private String playerSelection;
}
