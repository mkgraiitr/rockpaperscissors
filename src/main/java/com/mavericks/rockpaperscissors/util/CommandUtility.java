package com.mavericks.rockpaperscissors.util;

import java.util.Scanner;

import static com.mavericks.rockpaperscissors.enums.CommandLineMessage.QUITING;

public class CommandUtility {

    public static void exitCommandLine(Scanner scanner) {
        scanner.close();
        System.out.println(QUITING.getValue());
        System.exit(0);
    }

}
