package com.mavericks.rockpaperscissors.engine;

import com.mavericks.rockpaperscissors.players.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    private List<Round> rounds = new ArrayList<>();

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(Round round) {
        rounds.add(round);
    }
}
