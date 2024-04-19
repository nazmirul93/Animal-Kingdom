import java.awt.Color;

/**
 * The Bear class represents a bear critter in the simulation.
 * Bears are characterized by their color (white for polar bears,
 * black for non-polar bears) and their alternating symbol (/ or \).
 * They exhibit behavior to infect, hop, or turn left based on
 * their surroundings.
 */
public class Bear extends Critter {
    private boolean polar; // Indicates whether the bear is a polar bear
    private boolean slash; // Indicates whether to display a slash symbol

    /**
     * Constructs a new Bear object.
     *
     * @param polar true if the bear is a polar bear, false otherwise
     */
    public Bear(boolean polar) {
        this.polar = polar;
        this.slash = true; // Start with slash character
    }

    /**
     * Gets the color of the bear.
     *
     * @return Color.WHITE if polar, Color.BLACK otherwise
     */
    @Override
    public Color getColor() {
        return polar ? Color.WHITE : Color.BLACK;
    }

    /**
     * Gets the string representation of the bear.
     * Alternates between slash and backslash characters.
     *
     * @return "/" if slash is true, "\" otherwise
     */
    @Override
    public String toString() {
        String bearSymbol = slash ? "/" : "\\";
        slash = !slash; // Toggle for the next move
        return bearSymbol;
    }

    /**
     * Determines the action the bear should take based on its surroundings.
     * If an enemy is in front, the bear will always infect.
     * If the front space is empty, it will hop if possible.
     * Otherwise, it will turn left.
     *
     * @param info information about the bear's current environment
     * @return the action to take (INFECT, HOP, LEFT)
     */
    @Override
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }
}
