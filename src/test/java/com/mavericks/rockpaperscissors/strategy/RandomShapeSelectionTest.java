package com.mavericks.rockpaperscissors.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class RandomShapeSelectionTest {

    private RandomShapeSelection randomShapeSelection = new RandomShapeSelection();

    @Test
    void test_makeMove() {
        String playerSelection = randomShapeSelection.makeMove();
        assertNotNull(playerSelection);
    }
}