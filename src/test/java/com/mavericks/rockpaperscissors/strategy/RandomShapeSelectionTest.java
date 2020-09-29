package com.mavericks.rockpaperscissors.strategy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
class RandomShapeSelectionTest {

    @InjectMocks
    private RandomShapeSelection randomShapeSelection = new RandomShapeSelection();

    @Test
    void test_makeMove() {
        String playerSelection = randomShapeSelection.makeMove();
        assertNotNull(playerSelection);
    }
}