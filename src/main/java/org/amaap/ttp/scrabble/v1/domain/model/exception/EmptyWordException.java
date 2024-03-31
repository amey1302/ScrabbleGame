package org.amaap.ttp.scrabble.v1.domain.model.exception;

public class EmptyWordException extends InvalidWordException {

    public EmptyWordException(String message) {
        super(message);
    }
}
