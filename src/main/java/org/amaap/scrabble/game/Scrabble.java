package org.amaap.scrabble.game;

import org.amaap.scrabble.game.exception.InvalidWordException;
import org.amaap.scrabble.game.exception.WordContainsDigitsException;
import org.amaap.scrabble.game.exception.WordContainsSpecialCharactersException;

public class Scrabble {
    String word;

    private Scrabble(String word) {
        this.word = word;

    }

    public static Scrabble enterWord(String word) throws InvalidWordException {
        if (word.matches(".*\\d.*"))
            throw new WordContainsDigitsException("Word Contains Digits");
        else if (word.matches(".*[^A-Z^a-z].*"))
            throw new WordContainsSpecialCharactersException("Word Contain Special Characters");

        return new Scrabble(word);
    }
    public int score(String word){
        int score = 0;
        int[] POINTS = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
        for(int i=0; i < word.length(); i++ ){
            if(word.equals(word.toUpperCase()))
                score += POINTS[word.charAt(i) - 65];
            if(word.equals(word.toLowerCase()))
                score += POINTS[word.charAt(i) - 97];

        }
        return score;
    }

    public String getWord() {
        return word;
    }

}
