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
class GameHandlerTest {
    @Mock
    private Game game = new Game();

    @InjectMocks
    private ScoreBoard scoreBoard;

    @Test
    void playGame() {
        Player computerOne = new Robot();
        computerOne.setPlayerName("TestSiri");
        computerOne.setPlayerId("1");
        Player computerTwo = new Robot();
        computerTwo.setPlayerName("TestAlexa");
        computerTwo.setPlayerId("2");
        List<Player> list = new ArrayList<>();
        list.add(computerOne);
        list.add(computerTwo);
        game.playGame(list);
        int lastRoundIndex = scoreBoard.getRounds().size() - 1;

        int playerOneScore = scoreBoard.getRounds().get(lastRoundIndex).getPlayerStatistics().get(0).getTotalScore();
        int playerTwoScore = scoreBoard.getRounds().get(lastRoundIndex).getPlayerStatistics().get(1).getTotalScore();

        int winningScore = Math.max(playerOneScore, playerTwoScore);

        assertEquals(winningScore, Score.WINNING_SCORE.getValue());
    }
}