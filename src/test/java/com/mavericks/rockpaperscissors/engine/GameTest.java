package com.mavericks.rockpaperscissors.engine;

import com.mavericks.rockpaperscissors.players.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.mavericks.rockpaperscissors.util.GameUtility.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GameTest {
    private Game game = new Game();

    @Test
    void integrationTest_playGame() {
        Player computerOne = new Player("1", "TestSiri");
        computerOne.setNextMoveStrategy(new FixedMoveStrategy("1"));
        Player computerTwo = new Player("2", "TestAlexa");
        computerTwo.setNextMoveStrategy(new FixedMoveStrategy("2"));
        List<Player> list = new ArrayList<>();
        list.add(computerOne);
        list.add(computerTwo);
        int rounds = 5;
        Map<String, Integer> scores = game.play(list, rounds);
        Optional<String> playerId = finalWinner(scores);
        assertEquals("1", playerId.get());
        assertEquals(3, scores.get("1"));
    }
    @Test
    void integrationTest_game_loser() {
        Player computerOne = new Player("1", "TestSiri");
        computerOne.setNextMoveStrategy(new FixedMoveStrategy("1"));
        Player computerTwo = new Player("2", "TestAlexa");
        computerTwo.setNextMoveStrategy(new FixedMoveStrategy("2"));
        List<Player> list = new ArrayList<>();
        list.add(computerOne);
        list.add(computerTwo);
        int rounds = 5;
        Map<String, Integer> scores = game.play(list, rounds);
        Optional<String> playerId = finalWinner(scores);
        assertNotEquals("2", playerId.get());
        assertEquals(-3, scores.get("2"));
    }

    @Test
    void integrationTest_testScores() {
        Player one = new Player("1", "Ram");
        one.setNextMoveStrategy(new FixedMoveStrategy("1"));
        Player two = new Player("2", "Shyam");
        two.setNextMoveStrategy(new FixedMoveStrategy("2"));
        Player three = new Player("3", "Ghanshyam");
        three.setNextMoveStrategy(new FixedMoveStrategy("3"));
        List<Player> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        list.add(three);
        int rounds = 5;
        Map<String, Integer> scores = game.play(list, rounds);
        Optional<String> playerId = finalWinner(scores);
        assertEquals(2, scores.get("1"));
        assertEquals(-7, scores.get("2"));
        assertEquals(5, scores.get("3"));
    }
}