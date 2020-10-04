package com.mavericks.rockpaperscissors.strategy;

import java.util.Random;

import static com.mavericks.rockpaperscissors.enums.Shapes.*;

public class RandomShapeSelection implements NextMoveStrategy {

    @Override
    public String makeMove() {
        Random random = new Random();
        int selection = random.nextInt(3) + 1;
        return selection == 1 ? ROCK.getValue() : selection == 2 ? PAPER.getValue() : SCISSIORS.getValue();
    }
}
