package org.amaap.ttp.scrabble.v1.domain;

import org.amaap.ttp.scrabble.v1.domain.model.ScoreCalculator;
import org.amaap.ttp.scrabble.v1.domain.model.exception.InvalidWordException;

public class ScrabbleManager {
    private static ScrabbleManager scarbbleManager;
    private ScrabbleManager() {
    }
    public static synchronized ScrabbleManager getInstance(){
        if (scarbbleManager == null)
            scarbbleManager = new ScrabbleManager();
        return scarbbleManager;
    }

    public int getScoreForWord(String word) throws InvalidWordException {
        ScoreCalculator scoreCalculator = new ScoreCalculator();
        return scoreCalculator.getScoreForWord(word);
    }
}
