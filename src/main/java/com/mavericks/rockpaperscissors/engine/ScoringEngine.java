package com.mavericks.rockpaperscissors.engine;

import com.mavericks.rockpaperscissors.players.Player;
import com.mavericks.rockpaperscissors.util.GameUtility;

import java.util.List;

import static com.mavericks.rockpaperscissors.enums.Score.*;

public class ScoringEngine {

    public Round getRoundScore(List<Player> players) {
        Round round = new Round();
        for (Player player : players) {
            PlayerStatistics playerStatistics = new PlayerStatistics();
            playerStatistics.setId(player.getId());
            playerStatistics.setSelection(player.getPlayerMove());
            round.setPlayerStatistics(playerStatistics);
        }

        for (int playerOneIndex = 0; playerOneIndex < players.size(); playerOneIndex++) {
            for (int playerTwoIndex = playerOneIndex + 1; playerTwoIndex < players.size(); playerTwoIndex++) {

                PlayerStatistics playerOneStats = round.getPlayerStatistics().get(playerOneIndex);
                PlayerStatistics playerTwoStats = round.getPlayerStatistics().get(playerTwoIndex);

                if (playerOneStats.getSelection().equals(playerTwoStats.getSelection())) {
                    playerOneStats.updateScore(DRAW.getValue());
                    playerTwoStats.updateScore(DRAW.getValue());
                } else {
                    String winnerPlayerId = GameUtility.findWinner(playerOneStats, playerTwoStats);
                    if (winnerPlayerId.equals(playerOneStats.getId())) {
                        playerOneStats.updateScore(WIN.getValue());
                        playerTwoStats.updateScore(LOSE.getValue());
                    } else {
                        playerTwoStats.updateScore(WIN.getValue());
                        playerOneStats.updateScore(LOSE.getValue());
                    }
                }
                round.setPlayerStatistics(playerOneIndex, playerOneStats);
                round.setPlayerStatistics(playerTwoIndex, playerTwoStats);
            }
        }
        return round;
    }

}
