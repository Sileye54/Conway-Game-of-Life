package conway;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the board for Conway's Game of Life.
 */
public class ConwayBoard extends Board {
    private ConwayCell[][] board;

    /**
     * Initializes a ConwayBoard from a given board structure.
     * 
     * @param boardStructure 2D array representing the initial state of the board
     */
    public void initializeBoard(char[][] boardStructure) {
        int boardSize = boardStructure.length;
        board = new ConwayCell[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = new ConwayCell(i, j);
                board[i][j].setState(boardStructure[i][j] == 'X');
            }
        }
    }

    @Override
    public void printBoard() {
        System.out.println(board.length);
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y].getState()) {
                    System.out.print("X");
                } else {
                    System.out.print("_");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * Gets the states of the neighboring cells of a given cell.
     * 
     * @param Conwaycell the cell whose neighbors are to be found
     * @return list of boolean states of the neighboring cells
     */
    public List<Boolean> getNeighborCells(ConwayCell Conwaycell) {
        List<Boolean> neighborsCells = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;
        int posX = Conwaycell.getPosX();
        int posY = Conwaycell.getPosY();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue;
                int newPosX = posX + i;
                int newPosY = posY + j;
                if (newPosX >= 0 && newPosX < rows && newPosY >= 0 && newPosY < cols) {
                    neighborsCells.add(board[newPosX][newPosY].getState());
                }
            }
        }
        return neighborsCells;
    }

    /**
     * Gets the current state of the board.
     * 
     * @return 2D array of ConwayCell representing the board
     */
    public ConwayCell[][] getBoard() {
        return board;
    }

    /**
     * Sets the board to a new state.
     * 
     * @param board 2D array of ConwayCell representing the new state of the board
     */
    public void setBoard(ConwayCell[][] board) {
        this.board = board;
    }

    /**
     * Checks if this board is equal to another board.
     * 
     * @param other the other board to compare with
     * @return true if the boards are equal, false otherwise
     */
    public boolean isEqual(ConwayBoard other) {
        if (this.board.length != other.board.length) {
            return false;
        }
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (this.board[i][j].getState() != other.board[i][j].getState()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Creates a copy of the current board.
     * 
     * @return a new ConwayBoard instance that is a copy of the current board
     */
    public ConwayBoard copy() {
        ConwayBoard copy = new ConwayBoard();
        int boardSize = this.board.length;
        char[][] boardStructure = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                boardStructure[i][j] = this.board[i][j].getState() ? 'X' : '_';
            }
        }
        copy.initializeBoard(boardStructure);
        return copy;
    }
}