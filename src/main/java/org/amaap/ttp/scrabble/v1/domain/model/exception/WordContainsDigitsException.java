package org.amaap.ttp.scrabble.v1.domain.model.exception;

public class WordContainsDigitsException extends InvalidWordException{
    public WordContainsDigitsException(String message) {
        super(message);
    }
}
