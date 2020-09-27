package com.mavericks.rockpaperscissors.engine;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private List<PlayerSelection> playerSelections = new ArrayList<>();
    private List<PlayerScore> playerScores = new ArrayList<>();

    public List<PlayerSelection> getPlayerSelections() {
        return playerSelections;
    }

    public void setPlayerSelections(PlayerSelection playerSelection) {
        playerSelections.add(playerSelection);
    }

    public List<PlayerScore> getPlayerScores() {
        return playerScores;
    }

    public void setPlayerScores(int index, PlayerScore playerScore) {
        playerScores.set(index, playerScore);
    }

    public void setPlayerScores(PlayerScore playerScore) {
        playerScores.add(playerScore);
    }
}
