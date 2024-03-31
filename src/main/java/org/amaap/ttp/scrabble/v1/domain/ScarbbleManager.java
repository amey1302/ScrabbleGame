package org.amaap.ttp.scrabble.v1.domain;

import org.amaap.ttp.scrabble.v1.domain.model.ScoreCalculator;
import org.amaap.ttp.scrabble.v1.domain.model.exception.InvalidWordException;

public class ScarbbleManager {
    private static ScarbbleManager scarbbleManager;
    ScoreCalculator calculator = new ScoreCalculator();
    private ScarbbleManager() {

    }
    public static synchronized ScarbbleManager getInstance(){
        if (scarbbleManager == null)
            scarbbleManager = new ScarbbleManager();
        return scarbbleManager;
    }

    public int getScoreForWord(String word) throws InvalidWordException {
        return calculator.getScoreForWord(word);
    }
}
