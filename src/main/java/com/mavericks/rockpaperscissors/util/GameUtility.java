package com.mavericks.rockpaperscissors.util;


import com.mavericks.rockpaperscissors.engine.PlayerStatistics;
import com.mavericks.rockpaperscissors.enums.Shapes;
import com.mavericks.rockpaperscissors.players.Player;

import java.util.*;

public class GameUtility {
    public static String findWinner(PlayerStatistics playerOneStats, PlayerStatistics playerTwoStats) {
        if (((playerOneStats.getSelection().equals(Shapes.SCISSORS.getValue())
                && playerTwoStats.getSelection().equals(Shapes.PAPER.getValue()))
                || (playerOneStats.getSelection().equals(Shapes.ROCK.getValue())
                && playerTwoStats.getSelection().equals(Shapes.SCISSORS.getValue()))
                || (playerOneStats.getSelection().equals(Shapes.PAPER.getValue())
                && playerTwoStats.getSelection().equals(Shapes.ROCK.getValue())))) {
            return playerOneStats.getId();
        } else {
            return playerTwoStats.getId();
        }
    }

    public static String getPlayerName(List<Player> players, String playerId) {
        return players.stream().filter(player -> player.getId().equals(playerId)).findFirst().get().getName();
    }

    public static Optional<String> finalWinner(Map<String, Integer> scores) {
        if (new HashSet<>(scores.values()).size() > 1)
            return Optional.of(scores.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey());
        else
            return Optional.empty();
    }
}

