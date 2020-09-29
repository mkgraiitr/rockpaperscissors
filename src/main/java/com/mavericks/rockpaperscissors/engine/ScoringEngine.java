package com.mavericks.rockpaperscissors.engine;

import com.mavericks.rockpaperscissors.players.Player;
import com.mavericks.rockpaperscissors.util.GameUtility;

import java.util.List;

import static com.mavericks.rockpaperscissors.enums.Score.*;

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
                PlayerSelection playerOneSelection = round.getPlayerSelections().get(playerOneIndex);
                PlayerSelection playerTwoSelection = round.getPlayerSelections().get(playerTwoIndex);
                PlayerScore playerOneScore = round.getPlayerScores().get(playerOneIndex);
                PlayerScore playerTwoScore = round.getPlayerScores().get(playerTwoIndex);

                if (playerOneSelection.getPlayerSelection().equals(playerTwoSelection.getPlayerSelection())) {
                    playerOneScore.updateTotalScore(DRAW.getValue());
                    playerTwoScore.updateTotalScore(DRAW.getValue());
                } else {
                    String winnerPlayerId = GameUtility.findWinner(playerOneSelection, playerTwoSelection);
                    if (winnerPlayerId.equals(playerOneSelection.getPlayerId())) {
                        playerOneScore.updateTotalScore(WIN.getValue());
                        playerTwoScore.updateTotalScore(LOSE.getValue());
                    } else {
                        playerTwoScore.updateTotalScore(WIN.getValue());
                        playerOneScore.updateTotalScore(LOSE.getValue());
                    }
                }
                round.setPlayerScores(playerOneIndex, playerOneScore);
                round.setPlayerScores(playerTwoIndex, playerTwoScore);
            }
        }
        return round;
    }

}
