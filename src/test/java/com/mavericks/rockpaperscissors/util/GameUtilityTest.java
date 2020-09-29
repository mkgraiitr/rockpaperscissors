package com.mavericks.rockpaperscissors.util;

import com.mavericks.rockpaperscissors.engine.PlayerSelection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class GameUtilityTest {

    @Test
    public void test_gameWinner() {
        PlayerSelection playerOneSelection = new PlayerSelection();
        PlayerSelection playerTwoSelection = new PlayerSelection();
        playerOneSelection.setPlayerId("1");
        playerOneSelection.setPlayerSelection("PAPER");
        playerTwoSelection.setPlayerId("2");
        playerTwoSelection.setPlayerSelection("ROCK");
        String winnerId = GameUtility.findWinner(playerOneSelection, playerTwoSelection);
        assertEquals(winnerId, "1");
    }
}