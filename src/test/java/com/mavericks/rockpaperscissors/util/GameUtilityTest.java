package com.mavericks.rockpaperscissors.util;

import com.mavericks.rockpaperscissors.engine.PlayerStatistics;
import com.mavericks.rockpaperscissors.players.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameUtilityTest {

    @Test
    public void test_gameWinner() {
        PlayerStatistics playerOneStats = new PlayerStatistics();
        PlayerStatistics playerTwoStats = new PlayerStatistics();
        playerOneStats.setId("1");
        playerOneStats.setSelection("PAPER");
        playerTwoStats.setId("2");
        playerTwoStats.setSelection("ROCK");
        String winnerId = GameUtility.findWinner(playerOneStats, playerTwoStats);
        assertEquals(winnerId, "1");
    }
    @Test
    public void test_getGameWinner(){
        Map<String, Integer> scores = new HashMap<>();
        scores.put("1", 10);
        scores.put("2", 12);
        String winnerId = GameUtility.getGameWinner(scores);
        assertEquals("2", winnerId);

    }

    @Test
    public void test_getPlayerName(){
        Player playerOne = new Player("1", "Mama");
        Player playerTwo = new Player("2", "Aama");
        List<Player> players = new ArrayList<>();
        players.add(playerOne);
        players.add(playerTwo);
        String playerName = GameUtility.getPlayerName(players, "2");
        assertEquals("Aama", playerName);

    }
}