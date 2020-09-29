package com.mavericks.rockpaperscissors.handler;

import com.mavericks.rockpaperscissors.engine.Game;
import com.mavericks.rockpaperscissors.players.Human;
import com.mavericks.rockpaperscissors.players.Player;
import com.mavericks.rockpaperscissors.players.Robot;
import com.mavericks.rockpaperscissors.strategy.CommandLineSelection;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.mavericks.rockpaperscissors.enums.CommandLineMessage.*;
import static com.mavericks.rockpaperscissors.util.CommandUtility.exitCommandLine;

public class CommandHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static void receiveUserInputs() {
        List<Player> players = new ArrayList<>();
        System.out.println(WELCOME_MSG.getValue());
        boolean isCommandLineActive = true;
        while (isCommandLineActive) {
            try {
                System.out.println(CHOOSE_PLAYERS.getValue());
                int userInput = scanner.nextInt();
                for (int playerNumber = 1; playerNumber <= userInput; playerNumber++) {
                    System.out.println(ENTER_USERNAME.getValue());
                    String userName = scanner.next();
                    System.out.println(ENTER_USERTYPE.getValue());
                    int userType = scanner.nextInt();
                    Player player;
                    if (userType == 1) {
                        player = new Human();
                        player.setPlayerName(userName);
                        player.setPlayerId(String.valueOf(playerNumber));
                        player.setNextMoveStrategy(new CommandLineSelection(scanner));
                    } else {
                        player = new Robot();
                        player.setPlayerName(userName);
                        player.setPlayerId(String.valueOf(playerNumber));
                    }
                    players.add(player);
                }
                Game game = new Game();
                game.playGame(players);
                if (userInput == 3) {
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
}
