import java.awt.Color;

/**
 * The Giant class represents a giant critter in the simulation.
 * Giants are characterized by their gray color and their
 * alternating strings ("fee", "fie", "foe", "fum") displayed
 * every 6 moves.
 */
public class Giant extends Critter {
    private int movesCount; // Number of moves made by the Giant

    /**
     * Constructs a new Giant object.
     * Initializes the moves count to 0.
     */
    public Giant() {
        this.movesCount = 0;
    }

    /**
     * Gets the color of the Giant.
     *
     * @return Color.GRAY representing the color of the Giant.
     */
    public Color getColor() {
        return Color.GRAY;
    }

    /**
     * Gets the string representation of the Giant.
     * Alternates between "fee", "fie", "foe", "fum" strings
     * every 6 moves.
     *
     * @return String representation of the Giant.
     */
    public String toString() {
        int phase = (movesCount / 6) % 4;
        switch (phase) {
            case 0:
                return "fee";
            case 1:
                return "fie";
            case 2:
                return "foe";
            default:
                return "fum";
        }
    }

    /**
     * Determines the action the Giant should take based on its surroundings.
     * If an enemy is in front, the Giant will always infect.
     * If the front space is empty, it will hop if possible.
     * Otherwise, it will turn right.
     *
     * @param info information about the Giant's current environment
     * @return the action to take (INFECT, HOP, RIGHT)
     */
    public Action getMove(CritterInfo info) {
        movesCount++; // Increment the moves count
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }
}
