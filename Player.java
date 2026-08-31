/* 
 * Username: jil557
 * Description: Defines the common data and behaviours shared by all player types.
 */
abstract class Player {
    private String name;
    private int guesses;
    private int catsFound;
    private int score;
    protected int size;
    public Player(String name, int size) {
        this.name = name;
        this.size = size;
        this.guesses = 0;
        this.score = 0;
        this.catsFound = 0;
    }
    public int getScore() {
        return score;
    }
    public void recordGuess(GuessResult result) {
        guesses++;
        if (result == GuessResult.CORRECT) {
            catsFound++;
        }
        score += result.getScore();
    }
    public boolean allCatsFound(int numberOfCats) {
        if (catsFound == numberOfCats) {
            return true;
        } else {
            return false;
        }
    }
    public void printStatistics() {
        System.out.println("Player: " + name);
        System.out.println("Number of guesses: " + guesses);
        System.out.println("Cats found: " + catsFound);
        System.out.println("Score: " + score);
    }
    public abstract Position makeGuess();
    public String toString() {
        return name + " (Score: " + score + ")";
    }
}