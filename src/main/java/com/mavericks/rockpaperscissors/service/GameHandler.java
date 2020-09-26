package com.mavericks.rockpaperscissors.service;

import com.mavericks.rockpaperscissors.players.Player;
import com.mavericks.rockpaperscissors.model.ScoringEngine;

import java.util.ArrayList;
import java.util.List;

import static com.mavericks.rockpaperscissors.util.GameUtility.printOnConsole;

public class GameHandler {
    private List<Player> players = new ArrayList<>();
    public void playGame(Player playerOne, Player playerTwo) {

        ScoringEngine scoringEngine = new ScoringEngine();
        int round = 1;

        while (playerOne.getTotalScore() < 10 && playerTwo.getTotalScore() < 10) {
            String playerOneMove = playerOne.getPlayerMove();
            String playerTwoMove = playerTwo.getPlayerMove();

            if (scoringEngine.getCurrentRoundScore(playerOneMove, playerTwoMove) == 1) {
                playerOne.updateScore(1);
            }
            if (scoringEngine.getCurrentRoundScore(playerOneMove, playerTwoMove) == -1) {
                playerTwo.updateScore(1);
            }
            printOnConsole("In Round " + round + " " + playerOne.getPlayerName() + " selected:: " + playerOneMove + " and " + playerTwo.getPlayerName() + "selected:: " + playerTwoMove
                    + "\n" + playerOne + playerTwo + "\n");
            round++;
        }

        if (playerOne.getTotalScore() > playerTwo.getTotalScore()) {
            printOnConsole(playerOne.getPlayerName() + " is the winner");
        } else {
            printOnConsole(playerTwo.getPlayerName() + " is the winner");
        }
        players.add(playerOne);
        players.add(playerTwo);
    }

    public List<Player> getPlayers(){
        return players;
    }

}
