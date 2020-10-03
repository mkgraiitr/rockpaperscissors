package com.mavericks.rockpaperscissors.service;

import com.mavericks.rockpaperscissors.engine.Game;
import com.mavericks.rockpaperscissors.engine.ScoreBoard;
import com.mavericks.rockpaperscissors.enums.Score;
import com.mavericks.rockpaperscissors.players.Player;
import com.mavericks.rockpaperscissors.players.Robot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class GameTest {
    @Mock
    private Game game = new Game();

    @InjectMocks
    private ScoreBoard scoreBoard;

    @Test
    void playGame() {
        Player computerOne = new Robot("1", "TestSiri");
        Player computerTwo = new Robot("2", "TestAlexa");
        List<Player> list = new ArrayList<>();
        list.add(computerOne);
        list.add(computerTwo);
        int rounds = 1;
        game.playGame(list, rounds);
        int lastRoundIndex = scoreBoard.getRounds().size() - 1;

        int playerOneScore = scoreBoard.getRounds().get(lastRoundIndex).getPlayerStatistics().get(0).getScore();
        int playerTwoScore = scoreBoard.getRounds().get(lastRoundIndex).getPlayerStatistics().get(1).getScore();

        int winningScore = Math.max(playerOneScore, playerTwoScore);

        assertEquals(winningScore, Score.WINNING_SCORE.getValue());
    }
}