package org.amaap.ttp.scrabble.v1.domain.model;

public class ScoreCalculator {
    private static final int[] POINTS = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    public int getScoreForWord(String word) {
        int score = 0;
        String upperCaseWord = word.toUpperCase();
        for (int i = 0; i < word.length(); i++) {
            score += POINTS[upperCaseWord.charAt(i) - 'A'];
        }
        return score;
    }
}
