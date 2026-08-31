/*
 * Username: jil557
 * Description: Contains the enums and main method for the Meowdoku game.
 */

enum Colour {
    BLUE,
    RED,
    GREEN,
    YELLOW;
}

enum CellState {
    HIDDEN('_'),
    FOUND_CAT('C'),
    WRONG_GUESS('X');

    private char symbol;

    CellState(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}

enum GuessResult {
    CORRECT(10, "Correct!"),
    WRONG(-1, "No cat there!"),
    ALREADY_GUESSED(0, "Position already guessed!");

    private int score;
    private String message;

    GuessResult(int score, String message) {
        this.score = score;
        this.message = message;
    }

    public int getScore() {
        return score;
    }

    public String getMessage() {
        return message;
    }
}

public class A1 {
    public static void main(String[] args) {
        Player player = new SequentialPlayer("Player 1", 4);
        MeowdokuGame game = new MeowdokuGame(player, 4);
        game.play();
    }
}