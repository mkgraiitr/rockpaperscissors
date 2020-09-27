package com.mavericks.rockpaperscissors.controller;

import com.mavericks.rockpaperscissors.strategy.CommandLineSelection;
import com.mavericks.rockpaperscissors.players.Human;
import com.mavericks.rockpaperscissors.players.Player;
import com.mavericks.rockpaperscissors.players.Robot;
import com.mavericks.rockpaperscissors.service.GameHandler;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.mavericks.rockpaperscissors.enums.CommandLineMessage.*;
import static com.mavericks.rockpaperscissors.util.CommandUtility.exitCommandLine;
import static com.mavericks.rockpaperscissors.util.GameUtility.printOnConsole;

public class GameController {

    private static Scanner scanner;

    public static void runUserCommands() {
        scanner = new Scanner(System.in);
        printOnConsole(WELCOME_MSG.getValue());
        boolean isCommandLineActive = true;
        while (isCommandLineActive) {
            try {
                printOnConsole(CHOOSE_GAME.getValue());
                int userInput = scanner.nextInt();
                if (userInput == 3) {
                    isCommandLineActive = false;
                    exitCommandLine(scanner);
                }
                executeUserCommands(userInput);

            } catch (InputMismatchException e) {
                printOnConsole(INVALID_INPUT.getValue());
                scanner.nextLine();
            } catch (Exception e) {
                printOnConsole(e.getMessage());
                exitCommandLine(scanner);
            }
        }
    }

    private static void executeUserCommands(int userInput) {
        GameHandler gameHandler = new GameHandler();
        List<Player> players = new ArrayList<>();
        if (userInput == 1) {
            Player playerOne = new Robot();
            playerOne.setPlayerName("Siri");
            Player playerTwo = new Robot();
            playerTwo.setPlayerName("Alexa");
            players.add(playerOne);
            players.add(playerTwo);
            gameHandler.playGame(players);
        } else {
            printOnConsole(ENTER_NAME.getValue());
            String playerName = scanner.next();

            Player playerOne = new Human();
            playerOne.setPlayerName(playerName);
            playerOne.setNextMoveStrategy(new CommandLineSelection(scanner));
            Player playerTwo = new Robot();
            playerTwo.setPlayerName("Khaleesee");
            players.add(playerOne);
            players.add(playerTwo);
            gameHandler.playGame(players);
        }

    }
}
