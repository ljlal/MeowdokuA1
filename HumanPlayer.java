/*
 * Username: jil557
 * Description: Represents a player that enters guesses using keyboard input.
 */
import java.util.Scanner;
class HumanPlayer extends Player {
    private Scanner scanner;
    public HumanPlayer(String name, int size) {
        super(name, size);
        scanner = new Scanner(System.in);
    }
    public Position makeGuess() {
        int row = getValidPosition("Enter Row: ", size);
        int column = getValidPosition("Enter Column: ", size);
        return new Position(row, column);
    }
    private int getValidPosition(String prompt, int size) {
        int position;
        do {
            System.out.print(prompt);
            position = scanner.nextInt();
        } while (position < 0 || position >= size);
        return position;
    }
}