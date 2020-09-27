package com.mavericks.rockpaperscissors.strategy;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
class RandomShapeSelectionTest {

    @InjectMocks
    private RandomShapeSelection randomShapeSelection = new RandomShapeSelection();

    @Test
    void test_makeMove() {
        String playerSelection = randomShapeSelection.makeMove();
        assertNotNull(playerSelection);
    }
}