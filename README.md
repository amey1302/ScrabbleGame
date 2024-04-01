# Scrabble Manager OOMD 

## Problem Statement
Scrabble is a game where players attempt to create words from a set of letter tiles. Different letters have different points allocated to them. In the English alphabet, letters have the following point scores:

| Points | Letters               |
|--------|-----------------------|
| 1      | E, A, I, O, N, R, T, L, S, U |
| 2      | D, G                  |
| 3      | B, C, M, P            |
| 4      | F, H, V, W, Y         |
| 5      | K                     |
| 8      | J, X                  |
| 10     | Q, Z                  |

Calculate the score for a word. The score is the sum of the points for the letters that make up a word. For example: GUARDIAN = 2 + 1 + 1 + 1 + 2 + 1 + 1 + 1 = 10.

## Extensions
- Double or triple a letter 
- Double or triple a word

## Solution

### Code Coverage Report
![image](https://github.com/amey1302/ScrabbleGame/assets/114746925/064b83c3-fba6-4715-bf01-5fa79b5353ec)


### Package Structure
- `org.amaap.ttp.scrabble.v1.config`
  - `exception`
    - `InvalidLetterException`
  - `PointAllocator`
  
- `org.amaap.ttp.scrabble.v1.domain`
  - `model`
    - `exception`
      - `EmptyWordException`
      - `InvalidWordException`
      - `WordContainsDigitsException`
      - `WordContainSpecialCharacterException`
    - `validator`
      - `WordValidator`
        - **Behaviour**
          - `public static boolean isWordContainsSpecialCharacters(String word)`
          - `public static boolean isWordContainsDigits(String word)`
          - `public static boolean isValid(String word)`
    - `ScoreCalculator`
      - **Behaviour**
        - `public int getScoreForWord(String word)`
        - `private int getScore(char c)`
        - `public int getScoreForWordWithMultiplier(String word, int wordMultiplier)`
        - `public int getScoreWithLetterMultiplier(String originalWord, char letterToMultiply, int multiplier)`
  - `ScrabbleManager`
    - **Behaviour**
      - `public static synchronized ScrabbleManager getInstance()`
      - `public int getScoreForWord(String word)`
      - `public int getScoreForWordWithMultiplier(String word, int wordMultiplier)`
      - `public int getScoreWithLetterMultiplier(String originalWord, char letterToMultiply, int multiplier)`

