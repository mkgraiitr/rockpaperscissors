package com.mavericks.rockpaperscissors.model;

import com.mavericks.rockpaperscissors.players.Player;
import com.mavericks.rockpaperscissors.players.Robot;
import com.mavericks.rockpaperscissors.util.GameUtility;
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

    @InjectMocks
    private ScoringEngine scoringEngine = new ScoringEngine();

    @Before
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCurrentRoundScore() {
        Player playerOne = new Robot();
        playerOne.setPlayerName("TestSiri");
        Player playerTwo = new Robot();
        playerTwo.setPlayerName("TestAlexa");
        List<Player> players = new ArrayList<>();
        players.add(playerOne);
        players.add(playerTwo);
        List<Player> gamePlayers = scoringEngine.getPlayersWithRoundScore(players);
        Player gamePlayerOne = gamePlayers.get(0);
        Player gamePlayerTwo = gamePlayers.get(1);

        String playerOneSelection = gamePlayerOne.getHistoricalMove().get(0);
        String playerTwoSelection = gamePlayerTwo.getHistoricalMove().get(0);
        System.out.println("Player1:: " + playerOneSelection + " Player2:: " + playerTwoSelection);
        int playerOneScore = playerOneSelection.equals(playerTwoSelection) ? 0 : isPlayerOneWinner(playerOneSelection, playerTwoSelection) ? 1 : -1;
        assertEquals(playerOneScore, gamePlayerOne.getTotalScore());
    }
}