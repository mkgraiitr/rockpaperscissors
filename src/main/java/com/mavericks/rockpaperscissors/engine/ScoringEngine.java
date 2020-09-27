package com.mavericks.rockpaperscissors.engine;

import com.mavericks.rockpaperscissors.players.Player;

import java.util.List;

import static com.mavericks.rockpaperscissors.enums.Score.*;
import static com.mavericks.rockpaperscissors.util.GameUtility.isPlayerOneWinner;

public class ScoringEngine {

    Round round = new Round();

    public Round getPlayersWithRoundScore(List<Player> players) {
        for (Player player : players) {
            PlayerSelection playerSelection = new PlayerSelection();
            playerSelection.setPlayerId(player.getPlayerId());
            playerSelection.setPlayerSelection(player.getPlayerMove());
            round.setPlayerSelections(playerSelection);

            PlayerScore playerScore = new PlayerScore();
            playerScore.setPlayerId(player.getPlayerId());
            round.setPlayerScores(playerScore);
        }

        for (int playerOneIndex = 0; playerOneIndex < players.size(); playerOneIndex++) {
            for (int playerTwoIndex = playerOneIndex + 1; playerTwoIndex < players.size(); playerTwoIndex++) {
                String playerOneSelection = round.getPlayerSelections().get(playerOneIndex).getPlayerSelection();
                String playerTwoSelection = round.getPlayerSelections().get(playerTwoIndex).getPlayerSelection();
                PlayerScore playerOneScore = round.getPlayerScores().get(playerOneIndex);
                PlayerScore playerTwoScore = round.getPlayerScores().get(playerTwoIndex);

                if (playerOneSelection.equals(playerTwoSelection)) {
                    playerOneScore.updateTotalScore(DRAW.getValue());
                    playerTwoScore.updateTotalScore(DRAW.getValue());
                } else if (isPlayerOneWinner(playerOneSelection, playerTwoSelection)) {
                    playerOneScore.updateTotalScore(WIN.getValue());
                    playerTwoScore.updateTotalScore(LOSE.getValue());
                } else {
                    playerTwoScore.updateTotalScore(WIN.getValue());
                    playerOneScore.updateTotalScore(LOSE.getValue());
                }

                round.setPlayerScores(playerOneIndex, playerOneScore);
                round.setPlayerScores(playerTwoIndex, playerTwoScore);
            }
        }
        return round;
    }

}
