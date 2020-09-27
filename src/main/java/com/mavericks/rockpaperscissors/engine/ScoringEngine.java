package com.mavericks.rockpaperscissors.engine;

import com.mavericks.rockpaperscissors.players.Player;

import java.util.List;

import static com.mavericks.rockpaperscissors.enums.Score.*;
import static com.mavericks.rockpaperscissors.util.GameUtility.isPlayerOneWinner;

public class ScoringEngine {

    Round round = new Round();

    public Round getPlayersWithRoundScore(List<Player> players) {
        //return players.stream().flatMap(playerOne -> players.stream().filter(playerTwo -> !playerOne.equals(playerTwo))
        //  .map(ScoringEngine::updateCurrentRoundStats)).collect(Collectors.toList());
//        return players.stream().flatMap(playerOne -> players.stream().filter(playerTwo -> !playerOne.equals(playerTwo))
//          .map(player -> {updateCurrentRoundStats(playerOne, player); return player;})).collect(Collectors.toList());

        for (int playerOneIndex = 0; playerOneIndex < players.size(); playerOneIndex++) {
            for (int playerTwoIndex = playerOneIndex + 1; playerTwoIndex < players.size(); playerTwoIndex++) {
                updateCurrentRoundStats(players.get(playerOneIndex), players.get(playerTwoIndex));
            }
        }
        return round;
    }

    private void updateCurrentRoundStats(Player playerOne, Player playerTwo) {
        String playerOneMove = playerOne.getPlayerMove();
        String playerTwoMove = playerTwo.getPlayerMove();

        PlayerSelection playerSelectionOne = new PlayerSelection();
        PlayerSelection playerSelectionTwo = new PlayerSelection();
        playerSelectionOne.setPlayerSelection(playerOneMove);
        playerSelectionOne.setPlayerId(playerOne.getPlayerId());
        playerSelectionTwo.setPlayerSelection(playerTwoMove);
        playerSelectionTwo.setPlayerId(playerTwo.getPlayerId());

        PlayerScore playerScoreOne = new PlayerScore();
        PlayerScore playerScoreTwo = new PlayerScore();

        playerScoreOne.setPlayerId(playerOne.getPlayerId());
        playerScoreTwo.setPlayerId(playerTwo.getPlayerId());

        if (playerOneMove.equals(playerTwoMove)) {
            playerScoreOne.updateTotalScore(DRAW.getValue());
            playerScoreTwo.updateTotalScore(DRAW.getValue());
        } else if (isPlayerOneWinner(playerOneMove, playerTwoMove)) {
            playerScoreOne.updateTotalScore(WIN.getValue());
            playerScoreTwo.updateTotalScore(LOSE.getValue());
        } else {
            playerScoreTwo.updateTotalScore(WIN.getValue());
            playerScoreOne.updateTotalScore(LOSE.getValue());
        }
        round.setPlayerScores(playerScoreOne);
        round.setPlayerScores(playerScoreTwo);
        round.setPlayerSelections(playerSelectionOne);
        round.setPlayerSelections(playerSelectionTwo);
    }
}
