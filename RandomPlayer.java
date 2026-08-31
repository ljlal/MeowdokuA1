/*
 * Username: jil557
 * Description: Represents a player that generates random guesses on the board.
 */
import java.util.Random;
class RandomPlayer extends Player {
    private Random random;
    public RandomPlayer(String name, int size, int seed) {
        super(name, size);
        random = new Random(seed);
    }
    public Position makeGuess() {
        int row = random.nextInt(size);
        int column = random.nextInt(size);
        return new Position(row, column);
    }
}