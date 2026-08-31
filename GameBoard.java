/*
 * Username: jil557
 * Description: Represents the game board for the Meowdoku game, including the logic for checking guesses and displaying the board.
 */
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class GameBoard {
    private int size;
    private Cell[][] board;
    private int[] solution;
    private Colour[] colours;
    private Random random = new Random(30);
    public GameBoard(int size) {
        this.size = size;
        board = new Cell[size][size];
        int[][] solutions ={
            {2, 0, 3, 1},
            {1, 3, 0, 2}
        };
        solution = solutions[random.nextInt(solutions.length)];
        colours = new Colour[] {
            Colour.BLUE,
            Colour.RED,
            Colour.GREEN,
            Colour.YELLOW
        };
        List<Colour> list = Arrays.asList(colours);
        Collections.shuffle(list, random);
        initialiseBoard();
    }
    private void initialiseBoard() {
        placeInitialColours();
        for (int row = 0; row < size; row++) {
            expandRegion(row, solution[row], colours[row]);
        }
    }
    private void placeInitialColours() {
        for (int row = 0; row < size; row++) {
            board[row][solution[row]] = new Cell(colours[row]);
        }
    }
    private void expandRegion(int row, int column, Colour colour) {
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = column - 1; c <= column + 1; c++) {
                if (r >= 0 && r < size &&
                    c >= 0 && c < size &&
                    board[r][c] == null) {
                    board[r][c] = new Cell(colour);
                }
            }
        }
    }
    public GuessResult checkGuess(Position position) {
        int row = position.getRow();
        int column = position.getColumn();

        Cell cell = board[row][column];

        if (cell.getState() != CellState.HIDDEN) {
            return GuessResult.ALREADY_GUESSED;
        }
        if (solution[row] == column) {
            cell.setState(CellState.FOUND_CAT);
            return GuessResult.CORRECT;
        } else {
            cell.setState(CellState.WRONG_GUESS);
            return GuessResult.WRONG;
        }
    }
    public String toString() {
        String result = "";
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                result += board[row][column].toString();
            }
            if (row < size - 1) {
                result += "\n";
            }
        }
        return result;
    }
}