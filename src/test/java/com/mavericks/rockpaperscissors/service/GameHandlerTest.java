package com.mavericks.rockpaperscissors.service;

import com.mavericks.rockpaperscissors.players.Player;
import com.mavericks.rockpaperscissors.players.Robot;
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

    @InjectMocks
    private GameHandler gameHandler = new GameHandler();
    @Before
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void playGame() {
        Player computerOne = new Robot();
        computerOne.setPlayerName("TestSiri");
        Player computerTwo = new Robot();
        computerTwo.setPlayerName("TestAlexa");
        List<Player> list = new ArrayList<>();
        list.add(computerOne);
        list.add(computerTwo);
        gameHandler.playGame(list);
        List<Player> playerList = gameHandler.getPlayers();
        assertEquals(playerList.get(0).getTotalScore(), computerOne.getTotalScore());
        assertEquals(playerList.get(1).getTotalScore(), computerTwo.getTotalScore());
    }
}