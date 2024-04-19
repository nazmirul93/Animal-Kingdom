import java.awt.*;

/**
 * The NinjaCat class represents a special kind of cat that behaves like a ninja in the critter simulation.
 * It moves stealthily and unpredictably, avoiding detection and catching its prey by surprise.
 */
public class NinjaCat extends Critter {
    private static final Color[] COLORS = {Color.BLACK, Color.GRAY, Color.DARK_GRAY};
    private int movesCount;

    /**
     * Constructs a new NinjaCat object.
     */
    public NinjaCat() {
        this.movesCount = 0;
    }

    /**
     * Gets the color of the NinjaCat.
     *
     * @return a random color from the predefined array of colors
     */
    public Color getColor() {
        int colorIndex = movesCount % COLORS.length;
        return COLORS[colorIndex];
    }

    /**
     * Gets the string representation of the NinjaCat.
     *
     * @return a string representation of the NinjaCat
     */
    public String toString() {
        return "N";
    }

    /**
     * Determines the action the NinjaCat should take based on its surroundings.
     * The NinjaCat moves randomly, mimicking the stealthy and unpredictable nature of a ninja.
     *
     * @param info information about the NinjaCat's current environment
     * @return the action to take (HOP, LEFT, RIGHT, INFECT)
     */
    public Action getMove(CritterInfo info) {
        movesCount++;
        int randomMove = (int) (Math.random() * 3); // Generates a random number from 0 to 2
        switch (randomMove) {
            case 0:
                return Action.HOP;
            case 1:
                return Action.LEFT;
            case 2:
                return Action.RIGHT;
            default:
                return Action.INFECT;
        }
    }
}
