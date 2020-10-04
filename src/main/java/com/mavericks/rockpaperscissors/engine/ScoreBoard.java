package com.mavericks.rockpaperscissors.engine;

import com.mavericks.rockpaperscissors.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScoreBoard {
    private ScoringEngine scoringEngine = new ScoringEngine();
    private List<Round> rounds = new ArrayList<>();

    public List<Round> getRounds() {
        return rounds;
    }

    public void updateRoundDetails(List<Player> players) {
        Round round = scoringEngine.getPlayersWithRoundScore(players);
        System.out.println(round);
        rounds.add(round);
    }

    public Map<String, Integer> getScores() {
        return rounds.stream().flatMap(playerStats -> playerStats.getPlayerStatistics().stream())
                .collect(Collectors.groupingBy(PlayerStatistics::getId, Collectors.summingInt(PlayerStatistics::getScore)));
    }
}
