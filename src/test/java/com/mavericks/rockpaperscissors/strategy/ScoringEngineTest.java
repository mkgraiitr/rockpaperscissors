package com.mavericks.rockpaperscissors.strategy;

import com.mavericks.rockpaperscissors.engine.Round;
import com.mavericks.rockpaperscissors.engine.ScoringEngine;
import com.mavericks.rockpaperscissors.players.Player;
import com.mavericks.rockpaperscissors.players.Robot;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static com.mavericks.rockpaperscissors.util.GameUtility.isPlayerOneWinner;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
class ScoringEngineTest {

    private ScoringEngine scoringEngine = new ScoringEngine();

    @Before
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

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
        int actualScore = round.getPlayerScores().get(0).getTotalScore();
        String playerOneSelection = round.getPlayerSelections().get(0).getPlayerSelection();
        String playerTwoSelection = round.getPlayerSelections().get(1).getPlayerSelection();
        int expectedScore = playerOneSelection.equals(playerTwoSelection) ? 0 : isPlayerOneWinner(playerOneSelection, playerTwoSelection) ? 1 : -1;
        assertEquals(expectedScore, actualScore);
    }
}