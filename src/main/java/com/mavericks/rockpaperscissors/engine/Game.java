package com.mavericks.rockpaperscissors.engine;

import com.mavericks.rockpaperscissors.enums.CommandLineMessage;
import com.mavericks.rockpaperscissors.players.Player;

import java.util.*;

public class Game {

    private ScoreBoard scoreBoard = new ScoreBoard();

    public void playGame(List<Player> players, int numOfRounds) {
        int currentRound = 1;
        Map<String, Integer> playerScores = new HashMap<>();
        while (currentRound <= numOfRounds) {
            scoreBoard.updateRoundDetails(players);
            playerScores = scoreBoard.getPlayerScores();
            printPlayerScores(players, playerScores, currentRound);
            currentRound++;
        }

        playerScores = scoreBoard.getPlayerScores();
        String playerId = playerScores.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
        if (playerId !=null) {
            System.out.println(getPlayerName(players, playerId)+ CommandLineMessage.WINNER.getValue());
        } else {
            System.out.println(CommandLineMessage.GAME_TIED);
        }
    }

    private void printPlayerScores(List<Player> players, Map<String, Integer> playerScores, int currentRound) {
        playerScores.entrySet().forEach(player -> {
            System.out.println("At the end of round " + currentRound + ", Player " + getPlayerName(players, player.getKey()) + " scored :: " + player.getValue());
        });
    }

    private String getPlayerName(List<Player> players, String playerId) {
        return players.stream().filter(player -> player.getId().equals(playerId)).findFirst().get().getName();
    }
}
