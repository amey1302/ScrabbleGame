package org.amaap.ttp.scrabble.v1.domain.model.exception;

public class WordContainsSpecialCharactersException extends InvalidWordException {

    public WordContainsSpecialCharactersException(String message) {
        super(message);
    }
}
