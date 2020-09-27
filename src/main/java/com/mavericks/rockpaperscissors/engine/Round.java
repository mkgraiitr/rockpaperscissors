package com.mavericks.rockpaperscissors.engine;

import java.util.ArrayList;
import java.util.List;

public class Round {
    public List<PlayerSelection> getPlayerSelectionList() {
        return playerSelections;
    }

    public void setPlayerSelectionList(List<PlayerSelection> playerSelectionList) {
        this.playerSelections = playerSelectionList;
    }

    public List<PlayerScore> getPlayerScores() {
        return playerScores;
    }

    public void setPlayerScores(List<PlayerScore> playerScores) {
        this.playerScores = playerScores;
    }

    private List<PlayerSelection> playerSelections = new ArrayList<>();
    private List<PlayerScore> playerScores = new ArrayList<>();
}
