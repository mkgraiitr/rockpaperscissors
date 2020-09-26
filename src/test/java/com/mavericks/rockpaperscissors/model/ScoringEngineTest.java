package com.mavericks.rockpaperscissors.model;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        String playerOneSelection = "ROCK";
        String playerTwoSelection = "PAPER";

        assertEquals(-1, scoringEngine.getCurrentRoundScore(playerOneSelection, playerTwoSelection));
    }
}