package com.mavericks.rockpaperscissors.engine;

import com.mavericks.rockpaperscissors.players.Player;
import java.util.List;

import static com.mavericks.rockpaperscissors.enums.Score.*;
import static com.mavericks.rockpaperscissors.util.GameUtility.isPlayerOneWinner;

public class ScoringEngine {
    public List<Player> getPlayersWithRoundScore(List<Player> players) {
        //return players.stream().flatMap(playerOne -> players.stream().filter(playerTwo -> !playerOne.equals(playerTwo))
        //  .map(ScoringEngine::updateCurrentRoundStats)).collect(Collectors.toList());
//        return players.stream().flatMap(playerOne -> players.stream().filter(playerTwo -> !playerOne.equals(playerTwo))
//          .map(player -> {updateCurrentRoundStats(playerOne, player); return player;})).collect(Collectors.toList());

        for (int playerOneIndex = 0; playerOneIndex < players.size(); playerOneIndex++) {
            for (int playerTwoIndex = playerOneIndex + 1; playerTwoIndex < players.size(); playerTwoIndex++) {
                updateCurrentRoundStats(players.get(playerOneIndex), players.get(playerTwoIndex));
            }
        }
        return players;
    }

    private void updateCurrentRoundStats(Player playerOne, Player playerTwo) {
        String playerOneSelection = playerOne.getPlayerMove();
        String playerTwoSelection = playerTwo.getPlayerMove();

        playerOne.updateHistoricalMove(playerOneSelection);
        playerTwo.updateHistoricalMove(playerTwoSelection);

        if (playerOneSelection.equals(playerTwoSelection)) {
            playerOne.updateScore(DRAW.getValue());
            playerTwo.updateScore(DRAW.getValue());
        } else if (isPlayerOneWinner(playerOneSelection, playerTwoSelection)) {
            playerOne.updateScore(WIN.getValue());
            playerTwo.updateScore(LOSE.getValue());
        } else {
            playerTwo.updateScore(WIN.getValue());
            playerOne.updateScore(LOSE.getValue());
        }

    }
}
