package com.mavericks.rockpaperscissors.util;

import com.mavericks.rockpaperscissors.engine.PlayerStatistics;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
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
}