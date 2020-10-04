package com.mavericks.rockpaperscissors.service;

import com.mavericks.rockpaperscissors.engine.Game;
import com.mavericks.rockpaperscissors.players.Player;
import com.mavericks.rockpaperscissors.util.GameUtility;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {
    private Game game = new Game();

    @Test
    void playGame() {
        Player computerOne = new Player("1", "TestSiri");
        computerOne.setNextMoveStrategy(new FixedMoveStrategy("1"));
        Player computerTwo = new Player("2", "TestAlexa");
        computerTwo.setNextMoveStrategy(new FixedMoveStrategy("2"));
        List<Player> list = new ArrayList<>();
        list.add(computerOne);
        list.add(computerTwo);
        int rounds = 5;
        Map<String, Integer> playerScores = game.playGame(list, rounds);
        String playerId = GameUtility.getGameWinner(playerScores);
        assertEquals("1", playerId);

    }
}