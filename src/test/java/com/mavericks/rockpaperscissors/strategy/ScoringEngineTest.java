package com.mavericks.rockpaperscissors.strategy;

import com.mavericks.rockpaperscissors.engine.PlayerStatistics;
import com.mavericks.rockpaperscissors.engine.Round;
import com.mavericks.rockpaperscissors.engine.ScoringEngine;
import com.mavericks.rockpaperscissors.players.Player;
import com.mavericks.rockpaperscissors.players.Robot;
import com.mavericks.rockpaperscissors.util.GameUtility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static com.mavericks.rockpaperscissors.util.GameUtility.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class ScoringEngineTest {

    private ScoringEngine scoringEngine = new ScoringEngine();

    @Test
    void testCurrentRoundScore() {
        Player playerOne = new Robot();
        playerOne.setPlayerName("TestSiri");
        playerOne.setPlayerId("1");
        Player playerTwo = new Robot();
        playerTwo.setPlayerName("TestAlexa");
        playerTwo.setPlayerId("2");
        List<Player> players = new ArrayList<>();
        players.add(playerOne);
        players.add(playerTwo);
        Round round = scoringEngine.getPlayersWithRoundScore(players);
        int actualScore = round.getPlayerStatistics().get(0).getTotalScore();
        PlayerStatistics playerOneStats = round.getPlayerStatistics().get(0);
        PlayerStatistics playerTwoStats = round.getPlayerStatistics().get(1);
        int expectedScore;
        if (playerOneStats.getPlayerSelection().equals(playerTwoStats.getPlayerSelection())) {
            expectedScore = 0;
        } else {
            if (findWinner(playerOneStats, playerTwoStats).equals(playerOneStats.getPlayerId())) {
                expectedScore = 1;
            } else {
                expectedScore = -1;
            }
        }
        assertEquals(expectedScore, actualScore);
    }
}