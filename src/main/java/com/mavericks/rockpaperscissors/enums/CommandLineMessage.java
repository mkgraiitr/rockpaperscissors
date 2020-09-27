package com.mavericks.rockpaperscissors.enums;

public enum CommandLineMessage {

    INVALID_INPUT("Please provide valid input\n"),
    EXCEED_INVALID_ATTEMPTS("Sorry you have made 3 invalid attempts.\n"),
    GAME_OPTIONS("enter 1 for ROCK, 2 for PAPER and 3 for SCISSORS:: \n"),
    OUT_OF_RANGE("The entered value is not in range.\n"),
    ENTER_NAME("You selected to play with computer. Please enter your name!\n"),
    WELCOME_MSG("Dear user, welcome to rock, paper and scissors game. \n "),
    CHOOSE_PLAYERS("Dear user, please choose number of players:: "),
    CHOOSE_GAME("To play computer vs computer, please enter 1. \nTo play computer vs player please enter 2. \nTo quit please enter 3 on console! "),
    ENTER_USERNAME("Please enter user name:: "),
    ENTER_USERTYPE("Please enter user name:: "),
    QUITING("Thanks for playing rock paper scissors with us. Hope you enjoyed!!\n");

    private final String value;

    CommandLineMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}

