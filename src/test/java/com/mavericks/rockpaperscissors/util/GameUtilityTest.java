package com.mavericks.rockpaperscissors.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
public class GameUtilityTest {

    @Test
    public void test_gameWinner() {
        String shapeOne = "PAPER";
        String shapeTwo = "ROCK";
        boolean result = GameUtility.isPlayerOneWinner(shapeOne, shapeTwo);
        assertTrue(result);
    }
}