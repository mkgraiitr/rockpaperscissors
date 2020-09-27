package com.mavericks.rockpaperscissors.engine;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private List<PlayerSelection> playerSelections = new ArrayList<>();
    private List<PlayerScore> playerScores = new ArrayList<>();

    public List<PlayerSelection> getPlayerSelections() {
        return playerSelections;
    }

    public void setPlayerSelections(List<PlayerSelection> playerSelections) {
        this.playerSelections = playerSelections;
    }

    public List<PlayerScore> getPlayerScores() {
        return playerScores;
    }

    public void setPlayerScores(List<PlayerScore> playerScores) {
        this.playerScores = playerScores;
    }
}
