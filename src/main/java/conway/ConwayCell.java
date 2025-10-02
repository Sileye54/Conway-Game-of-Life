package conway;

import java.util.Collections;
import java.util.List;

/** Represents a cell in Conway's Game of Life */
public class ConwayCell extends Cell {
    private Position position;
    private CellState state;

    /**
     * Constructs a ConwayCell at the given position.
     * 
     * @param posX the x-coordinate of the cell
     * @param posY the y-coordinate of the cell
     */
    public ConwayCell(Position position, CellState state) {
        this.position = position;
        this.state = state;
    }

    /**
     * Determines if the cell's state should switch based on its neighbors.
     * 
     * @param neighbors list of boolean states of neighboring cells
     * @return true if the cell's state should switch, false otherwise
     */
    public boolean isStateSwitching(List<CellState> neighbors) {
        int neighborsAlive = Collections.frequency(neighbors, CellState.ALIVE);
        if (state == CellState.ALIVE && (neighborsAlive > 3 || neighborsAlive < 2)) {
            return true;
        }
        if (state == CellState.DEAD && neighborsAlive == 3) {
            return true;
        }
        return false;
    }

    @Override
    public void switchState() {
        if (state == CellState.ALIVE) {
            state = CellState.DEAD;
        } else {
            state = CellState.ALIVE;
        }
    }

    /**
     * Gets the position of the cell.
     * @return
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Gets the state of the cell.
     * 
     * @return true if the cell is alive, false if it is dead
     */
    public CellState getState() {
        return state;
    }

}
