package com.mavericks.rockpaperscissors.engine;

import com.mavericks.rockpaperscissors.players.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mavericks.rockpaperscissors.util.CommandUtility.printPlayerScores;

public class Game {

    private ScoreBoard scoreBoard = new ScoreBoard();

    public Map<String, Integer> playGame(List<Player> players, int numOfRounds) {
        int currentRound = 1;
        Map<String, Integer> playerScores = new HashMap<>();
        while (currentRound <= numOfRounds) {
            scoreBoard.updateRoundDetails(players);
            playerScores = scoreBoard.getPlayerScores();
            printPlayerScores(players, playerScores, currentRound);
            currentRound++;
        }
        return playerScores;
    }
}
