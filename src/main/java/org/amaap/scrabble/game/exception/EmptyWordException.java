package org.amaap.scrabble.game.exception;

public class EmptyWordException extends InvalidWordException {

    public EmptyWordException(String message) {
        super(message);
    }
}
