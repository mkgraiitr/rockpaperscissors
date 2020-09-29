package com.mavericks.rockpaperscissors.engine;

import com.mavericks.rockpaperscissors.players.Player;
import com.mavericks.rockpaperscissors.util.GameUtility;

import java.util.List;

import static com.mavericks.rockpaperscissors.enums.Score.*;

public class ScoringEngine {

    public Round getPlayersWithRoundScore(List<Player> players) {
        Round round = new Round();
        for (Player player : players) {
            PlayerStatistics playerStatistics = new PlayerStatistics();
            playerStatistics.setPlayerId(player.getPlayerId());
            playerStatistics.setPlayerSelection(player.getPlayerMove());
            round.setPlayerStatistics(playerStatistics);
        }

        for (int playerOneIndex = 0; playerOneIndex < players.size(); playerOneIndex++) {
            for (int playerTwoIndex = playerOneIndex + 1; playerTwoIndex < players.size(); playerTwoIndex++) {

                PlayerStatistics playerOneStats = round.getPlayerStatistics().get(playerOneIndex);
                PlayerStatistics playerTwoStats = round.getPlayerStatistics().get(playerTwoIndex);

                if (playerOneStats.getPlayerSelection().equals(playerTwoStats.getPlayerSelection())) {
                    playerOneStats.updateTotalScore(DRAW.getValue());
                    playerTwoStats.updateTotalScore(DRAW.getValue());
                } else {
                    String winnerPlayerId = GameUtility.findWinner(playerOneStats, playerTwoStats);
                    if (winnerPlayerId.equals(playerOneStats.getPlayerId())) {
                        playerOneStats.updateTotalScore(WIN.getValue());
                        playerTwoStats.updateTotalScore(LOSE.getValue());
                    } else {
                        playerTwoStats.updateTotalScore(WIN.getValue());
                        playerOneStats.updateTotalScore(LOSE.getValue());
                    }
                }
                round.setPlayerStatistics(playerOneIndex, playerOneStats);
                round.setPlayerStatistics(playerTwoIndex, playerTwoStats);
            }
        }
        return round;
    }

}
