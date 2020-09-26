package com.mavericks.rockpaperscissors.exception;

public class InvalidCommandArgumentException extends RuntimeException {
    public InvalidCommandArgumentException(String message) {
        super(message);
    }
}
