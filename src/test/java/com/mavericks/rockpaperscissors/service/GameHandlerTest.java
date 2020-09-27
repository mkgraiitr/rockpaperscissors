package com.mavericks.rockpaperscissors.service;

import com.mavericks.rockpaperscissors.controller.Game;
import com.mavericks.rockpaperscissors.engine.ScoreBoard;
import com.mavericks.rockpaperscissors.enums.Score;
import com.mavericks.rockpaperscissors.players.Player;
import com.mavericks.rockpaperscissors.players.Robot;
import com.mavericks.rockpaperscissors.util.GameUtility;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
class GameHandlerTest {
    private Game game = new Game();

    @Test
    void playGame() {
        Player computerOne = new Robot();
        computerOne.setPlayerName("TestSiri");
        computerOne.setPlayerId("1");
        Player computerTwo = new Robot();
        computerTwo.setPlayerName("TestAlexa");
        computerOne.setPlayerId("2");
        List<Player> list = new ArrayList<>();
        list.add(computerOne);
        list.add(computerTwo);
        game.playGame(list);
        ScoreBoard scoreBoard = game.getScoreBoard();
        String playerOneSelection = scoreBoard.getRounds().get(0).getPlayerSelections().get(0).getPlayerSelection();
        String playerTwoSelection = scoreBoard.getRounds().get(0).getPlayerSelections().get(1).getPlayerSelection();

        int playerOneScore = playerOneSelection.equals(playerTwoSelection) ? 0 : GameUtility.isPlayerOneWinner(playerOneSelection, playerTwoSelection) ? 1 : -1;
        assertEquals(playerOneScore, scoreBoard.getRounds().get(0).getPlayerScores().get(0).getTotalScore());
        //assertEquals(playerList.get(1).getTotalScore(), computerTwo.getTotalScore());
    }
}