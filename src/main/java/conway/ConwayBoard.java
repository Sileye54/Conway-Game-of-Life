package conway;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the board for Conway's Game of Life.
 */
public class ConwayBoard extends Board {
    private ConwayCell[][] board;
    private int numberOfIterations;

    /**
     * Initializes a ConwayBoard from a given board structure.
     * 
     * @param boardStructure 2D array representing the initial state of the board
     */
    public void initializeBoard(ConwayGameArguments conwayGameArguments) {
        char[][] boardStructure = conwayGameArguments.getBoardStructure();
        numberOfIterations = conwayGameArguments.getNumberOfIterations();
        int boardSize = boardStructure.length;
        board = new ConwayCell[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                Position position = new Position(i, j);
                CellState state = boardStructure[i][j] == 'X' ? CellState.ALIVE : CellState.DEAD;
                board[i][j] = new ConwayCell(position, state);
            }
        }

    }
    @Override
    public void simulate() {
        for (int i = 0; i < numberOfIterations; i++) {
            ConwayCell[][] newBoard = copy().getBoard();
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[x].length; y++) {
                    if (board[x][y].isStateSwitching(this.getNeighborCellStates(board[x][y]))) {
                        newBoard[x][y].switchState();
                    }
                }
            }
            board = newBoard;
        }
    }

    @Override
    public void printBoard() {
        System.out.println(board.length);
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y].getState() == CellState.ALIVE) {
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
    public List<CellState> getNeighborCellStates(ConwayCell Conwaycell) {
        List<CellState> neighborsCells = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;
        Position position = Conwaycell.getPosition();
        int posX = position.getX();
        int posY = position.getY();
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
        int boardSize = this.board.length;
        ConwayBoard copy = new ConwayBoard();
        ConwayCell[][] newBoard = new ConwayCell[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                Position position = new Position(i, j);
                CellState state = this.board[i][j].getState();
                newBoard[i][j] = new ConwayCell(position, state);
            }
        }
        copy.setBoard(newBoard);
        return copy;
    }
}