import java.awt.Color;

/**
 * The WhiteTiger class represents a white tiger critter in the simulation.
 * WhiteTigers exhibit behavior similar to Tigers but always have a white color.
 * They also change colors every three moves.
 */
public class WhiteTiger extends Tiger {
    private boolean infected; // Indicates whether the WhiteTiger has infected another Critter

    /**
     * Constructs a new WhiteTiger object.
     * Initializes the infected status to false.
     */
    public WhiteTiger() {
        this.infected = false;
    }

    /**
     * Gets the color of the WhiteTiger.
     * Always returns Color.WHITE.
     *
     * @return Color.WHITE representing the color of the WhiteTiger.
     */
    public Color getColor() {
        return Color.WHITE;
    }

    /**
     * Gets the string representation of the WhiteTiger.
     * Returns "tgr" if it hasn’t infected another Critter yet,
     * "TGR" if it has infected.
     *
     * @return String representation of the WhiteTiger.
     */
    public String toString() {
        return infected ? "TGR" : "tgr";
    }

    /**
     * Determines the action the WhiteTiger should take based on its surroundings.
     * Same as the Tiger class. Note: we need to override this method to
     * figure out if it has infected another Critter.
     *
     * @param info information about the WhiteTiger's current environment
     * @return the action to take (INFECT, HOP, LEFT, RIGHT)
     */
    public Action getMove(CritterInfo info) {
        Action action = super.getMove(info);
        if (action == Action.INFECT) {
            infected = true;
        }
        return action;
    }
}
