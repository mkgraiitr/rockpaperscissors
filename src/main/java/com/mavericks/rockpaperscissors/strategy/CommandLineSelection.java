package com.mavericks.rockpaperscissors.strategy;

import com.mavericks.rockpaperscissors.enums.Shapes;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.mavericks.rockpaperscissors.enums.CommandLineMessage.*;
import static com.mavericks.rockpaperscissors.util.CommandUtility.exitCommandLine;

public class CommandLineSelection implements NextMoveStrategy {
    private Scanner scanner;
    private String id;

    public CommandLineSelection(String id, Scanner userCommand) {
        this.id = id;
        this.scanner = userCommand;
    }

    @Override
    public String makeMove() {
        int userSelection = 0;
        int invalidAttempts = 0;
        boolean isCommandLineActive = true;
        while (isCommandLineActive && invalidAttempts < 4) {
            try {
                if (invalidAttempts == 3) {
                    System.out.println(EXCEED_INVALID_ATTEMPTS.getValue());
                    exitCommandLine(scanner);
                }
                System.out.println("Player id " + id + ", " + GAME_OPTIONS.getValue());
                userSelection = scanner.nextInt();
                if (userSelection > 3 || userSelection < 1) {
                    System.out.println(OUT_OF_RANGE.getValue());
                    invalidAttempts++;
                    scanner.nextLine();
                    isCommandLineActive = true;
                } else {
                    isCommandLineActive = false;
                }

            } catch (InputMismatchException inputException) {
                invalidAttempts++;
                System.out.println(INVALID_INPUT.getValue());
                scanner.nextLine();
            }
        }
        return userSelection == 1 ? Shapes.ROCK.getValue() : userSelection == 2 ? Shapes.PAPER.getValue() : Shapes.SCISSORS.getValue();
    }

}
