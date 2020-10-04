package com.mavericks.rockpaperscissors.engine;

import com.mavericks.rockpaperscissors.players.Player;
import com.mavericks.rockpaperscissors.players.Robot;
import com.mavericks.rockpaperscissors.util.GameUtility;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.mavericks.rockpaperscissors.util.GameUtility.findWinner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ScoringEngineTest {

    private ScoringEngine scoringEngine = new ScoringEngine();

    @Test
    void threePlayersGame_test_winner() {
        Player playerOne = new Robot("1", "TestSiri");
        playerOne.setNextMoveStrategy(new FixedMoveStrategy("1"));
        Player playerTwo = new Robot("2", "TestAlexa");
        playerTwo.setNextMoveStrategy(new FixedMoveStrategy("2"));
        Player playerThree = new Robot("3", "TestShaboo");
        playerThree.setNextMoveStrategy(new FixedMoveStrategy("3"));
        List<Player> players = new ArrayList<>();
        players.add(playerOne);
        players.add(playerTwo);
        players.add(playerThree);
        Game game = new Game();
        Map<String, Integer> playerScores = game.play(players, 5);
        Optional<String> gameWinner = GameUtility.finalWinner(playerScores);
        assertEquals("3", gameWinner.get());
        assertNotEquals("1", gameWinner.get());
        assertNotEquals("2", gameWinner.get());
    }

    @Test
    void threePlayersGame_test_scores() {
        Player playerOne = new Robot("1", "TestSiri");
        playerOne.setNextMoveStrategy(new FixedMoveStrategy("1"));
        Player playerTwo = new Robot("2", "TestAlexa");
        playerTwo.setNextMoveStrategy(new FixedMoveStrategy("2"));
        Player playerThree = new Robot("3", "TestShaboo");
        playerThree.setNextMoveStrategy(new FixedMoveStrategy("3"));
        List<Player> players = new ArrayList<>();
        players.add(playerOne);
        players.add(playerTwo);
        players.add(playerThree);
        Game game = new Game();
        Map<String, Integer> playerScores = game.play(players, 5);
        Optional<String> gameWinner = GameUtility.finalWinner(playerScores);
        assertEquals(2, playerScores.get("1"));
        assertEquals(-7, playerScores.get("2"));
        assertEquals(5, playerScores.get("3"));
    }

    @Test
    void twoPlayersGame_test_loser() {
        Player playerOne = new Robot("1", "TestSiri");
        playerOne.setNextMoveStrategy(new FixedMoveStrategy("1"));
        Player playerTwo = new Robot("2", "TestAlexa");
        playerTwo.setNextMoveStrategy(new FixedMoveStrategy("2"));
        List<Player> players = new ArrayList<>();
        players.add(playerOne);
        players.add(playerTwo);
        Game game = new Game();
        Map<String, Integer> playerScores = game.play(players, 5);
        Optional<String> gameWinner = GameUtility.finalWinner(playerScores);
        assertNotEquals("2", gameWinner.get());
        assertEquals(-3, playerScores.get("2"));
    }

    @Test
    void testCurrentRoundScore_twoPlayers_randomSelection() {
        Player playerOne = new Robot("1", "TestSiri");
        Player playerTwo = new Robot("2", "TestAlexa");
        List<Player> players = new ArrayList<>();
        players.add(playerOne);
        players.add(playerTwo);
        Round round = scoringEngine.getRoundScore(players);
        int actualScore = round.getPlayerStatistics().get(0).getScore();
        PlayerStatistics playerOneStats = round.getPlayerStatistics().get(0);
        PlayerStatistics playerTwoStats = round.getPlayerStatistics().get(1);
        int expectedScore;
        if (playerOneStats.getSelection().equals(playerTwoStats.getSelection())) {
            expectedScore = 0;
        } else {
            if (findWinner(playerOneStats, playerTwoStats).equals(playerOneStats.getId())) {
                expectedScore = 1;
            } else {
                expectedScore = -1;
            }
        }
        assertEquals(expectedScore, actualScore);
    }
}