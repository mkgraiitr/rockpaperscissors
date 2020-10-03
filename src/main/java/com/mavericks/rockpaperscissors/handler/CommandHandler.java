package com.mavericks.rockpaperscissors.handler;

import com.mavericks.rockpaperscissors.engine.Game;
import com.mavericks.rockpaperscissors.enums.PlayerType;
import com.mavericks.rockpaperscissors.players.Human;
import com.mavericks.rockpaperscissors.players.Player;
import com.mavericks.rockpaperscissors.players.Robot;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.mavericks.rockpaperscissors.enums.CommandLineMessage.*;
import static com.mavericks.rockpaperscissors.util.CommandUtility.exitCommandLine;

public class CommandHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static void handle() {
        System.out.println(WELCOME_MSG.getValue());
        boolean isCommandLineActive = true;
        while (isCommandLineActive) {
            try {
                System.out.println(ENTER_PLAYERS.getValue());
                int userInput = scanner.nextInt();
                List<Player> players = getPlayerDetails(userInput);
                System.out.println(ENTER_ROUNDS.getValue());
                int rounds = scanner.nextInt();
                startGame(players, rounds);
                if (userInput == 0) {
                    isCommandLineActive = false;
                    exitCommandLine(scanner);
                }
            } catch (InputMismatchException e) {
                System.out.println(INVALID_INPUT.getValue());
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                exitCommandLine(scanner);
            }
        }
    }

    private static List<Player> getPlayerDetails(int userInput) {
        List<Player> players = new ArrayList<>();
        for (int playerNumber = 1; playerNumber <= userInput; playerNumber++) {
            System.out.println(ENTER_PLAYER_NAME.getValue());
            String playerName = scanner.next();
            System.out.println(ENTER_PLAYER_TYPE.getValue());
            int selectedPlayerType = scanner.nextInt();
            PlayerType playerType = PlayerType.getPlayerType(selectedPlayerType);
            Player player = null;
            switch (playerType) {
                case HUMAN:
                    player = new Human(String.valueOf(playerNumber), playerName, scanner);
                    players.add(player);
                    break;
                case ROBOT:
                    player = new Robot(String.valueOf(playerNumber), playerName);
                    players.add(player);
                    break;
                default:
                    System.out.println(TYPE_NOT_SUPPORTED.getValue());
                    scanner.nextLine();
            }
        }
        return players;
    }

    private static void startGame(List<Player> players, int rounds) {
        Game game = new Game();
        game.playGame(players, rounds);
    }
}
