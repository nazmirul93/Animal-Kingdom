import java.awt.Color;
import java.util.Random;

/**
 * The Tiger class represents a tiger critter in the simulation.
 * Tigers exhibit behavior to infect, hop, or turn left based on
 * their surroundings. They also change colors every three moves.
 */
public class Tiger extends Critter {
    private int colorPhase; // Current color phase of the Tiger

    /**
     * Constructs a new Tiger object.
     * Initializes the color phase to a random value between 0 and 2.
     */
    public Tiger() {
        this.colorPhase = new Random().nextInt(3);
    }

    /**
     * Gets the color of the Tiger.
     * Randomly picks one of three colors (Color.RED, Color.GREEN, Color.BLUE)
     * based on the current color phase.
     *
     * @return Color representing the color of the Tiger.
     */
    public Color getColor() {
        switch (colorPhase) {
            case 0:
                return Color.RED;
            case 1:
                return Color.GREEN;
            default:
                return Color.BLUE;
        }
    }

    /**
     * Gets the string representation of the Tiger.
     *
     * @return "TGR" representing the string representation of the Tiger.
     */
    public String toString() {
        return "TGR";
    }

    /**
     * Determines the action the Tiger should take based on its surroundings.
     * If an enemy is in front, the Tiger will always infect.
     * If a wall is in front or to the right, then turn left.
     * Otherwise, if a fellow Tiger is in front, then turn right,
     * otherwise hop.
     *
     * @param info information about the Tiger's current environment
     * @return the action to take (INFECT, HOP, LEFT, RIGHT)
     */
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getRight() == Neighbor.WALL || info.getFront() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }
}
