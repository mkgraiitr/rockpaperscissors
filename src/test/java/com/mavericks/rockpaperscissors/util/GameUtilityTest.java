package com.mavericks.rockpaperscissors.util;

import com.mavericks.rockpaperscissors.engine.PlayerStatistics;
import com.mavericks.rockpaperscissors.players.Player;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.mavericks.rockpaperscissors.util.GameUtility.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GameUtilityTest {

    @Test
    public void test_currentRound_winner() {
        PlayerStatistics playerOneStats = new PlayerStatistics();
        PlayerStatistics playerTwoStats = new PlayerStatistics();
        playerOneStats.setId("1");
        playerOneStats.setSelection("PAPER");
        playerTwoStats.setId("2");
        playerTwoStats.setSelection("ROCK");
        String winnerId = findWinner(playerOneStats, playerTwoStats);
        assertEquals(winnerId, "1");
    }

    @Test
    public void test_currentRound_loser() {
        PlayerStatistics playerOneStats = new PlayerStatistics();
        PlayerStatistics playerTwoStats = new PlayerStatistics();
        playerOneStats.setId("1");
        playerOneStats.setSelection("SCISSOR");
        playerTwoStats.setId("2");
        playerTwoStats.setSelection("ROCK");
        String winnerId = findWinner(playerOneStats, playerTwoStats);
        assertNotEquals(winnerId, "1");
    }

    @Test
    public void test_final_winner() {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("1", 10);
        scores.put("2", 12);
        Optional<String> winnerId = finalWinner(scores);
        assertEquals("2", winnerId.get());
    }

    @Test
    public void test_final_loser() {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("1", 6);
        scores.put("2", 9);
        Optional<String> winnerId = finalWinner(scores);
        assertNotEquals("1", winnerId.get());
    }

    @Test
    public void test_getPlayerName() {
        Player playerOne = new Player("1", "Mama");
        Player playerTwo = new Player("2", "Aama");
        List<Player> players = new ArrayList<>();
        players.add(playerOne);
        players.add(playerTwo);
        String playerName = getPlayerName(players, "2");
        assertEquals("Aama", playerName);
    }

    @Test
    public void test_wrong_PlayerName() {
        Player playerOne = new Player("1", "Love");
        Player playerTwo = new Player("2", "Kush");
        List<Player> players = new ArrayList<>();
        players.add(playerOne);
        players.add(playerTwo);
        String playerName = getPlayerName(players, "2");
        assertNotEquals("Love", playerName);
    }
}