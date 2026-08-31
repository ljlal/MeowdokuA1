/* 
 * Username: jil557
 * Description: Represents a player that guesses board positions in sequential order.
 */
class SequentialPlayer extends Player {
    private int nextPosition=0;
    public SequentialPlayer(String name, int size) {
        super(name, size);
    }
    public Position makeGuess() {
        int row = nextPosition / size;
        int column = nextPosition % size;
        nextPosition = (nextPosition + 1) % (size * size);
        return new Position(row, column);
    }
}