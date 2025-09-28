package conway;

import java.util.Collections;
import java.util.List;

/** Represents a cell in Conway's Game of Life */
public class ConwayCell extends Cell {
    private int posX;
    private int posY;
    private boolean alive;

    /**
     * Constructs a ConwayCell at the given position.
     * 
     * @param posX the x-coordinate of the cell
     * @param posY the y-coordinate of the cell
     */
    public ConwayCell(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.alive = false;
    }

    /**
     * Determines if the cell's state should switch based on its neighbors.
     * 
     * @param neighbors list of boolean states of neighboring cells
     * @return true if the cell's state should switch, false otherwise
     */
    public boolean isStateSwitching(List<Boolean> neighbors) {
        int neighborsAlive = Collections.frequency(neighbors, true);
        if (alive && (neighborsAlive > 3 || neighborsAlive < 2)) {
            return true;
        }
        if (!alive && neighborsAlive == 3) {
            return true;
        }
        return false;
    }

    @Override
    public void switchState() {
        alive = !alive;
    }

    /**
     * Sets the state of the cell.
     * 
     * @param alive true if the cell is alive, false if it is dead
     */
    public void setState(boolean alive) {
        this.alive = alive;
    }

    /**
     * Gets the x-coordinate of the cell.
     * 
     * @return x-coordinate of the cell
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Gets the y-coordinate of the cell.
     * 
     * @return y-coordinate of the cell
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Gets the state of the cell.
     * 
     * @return true if the cell is alive, false if it is dead
     */
    public boolean getState() {
        return alive;
    }

}
