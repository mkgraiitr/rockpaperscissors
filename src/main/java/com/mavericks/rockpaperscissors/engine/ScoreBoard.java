package com.mavericks.rockpaperscissors.engine;

import com.mavericks.rockpaperscissors.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class ScoreBoard {
    private ScoringEngine scoringEngine = new ScoringEngine();
    private List<Round> rounds = new ArrayList<>();

    public List<Round> getRounds() {
        return rounds;
    }

    public void playRound(List<Player> players) {
        Round round = scoringEngine.getRoundScore(players);
        System.out.println(round);
        rounds.add(round);
    }

    public Map<String, Integer> getScores() {
        return rounds.stream().flatMap(player -> player.getPlayerStatistics().stream())
                .collect(groupingBy(PlayerStatistics::getId, summingInt(PlayerStatistics::getScore)));
    }
}
