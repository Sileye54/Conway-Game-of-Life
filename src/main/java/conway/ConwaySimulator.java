package conway;

/**
 * The ConwaySimulator class implements the Simulator interface to simulate the
 * Game of Life.
 */
public class ConwaySimulator implements Simulator<ConwayBoard> {
    @Override
    public void simulate(ConwayBoard conwayBoard, int numberOfIterations) {
        for (int i = 0; i < numberOfIterations; i++) {
            ConwayCell[][] board = conwayBoard.getBoard();
            ConwayCell[][] newBoard = conwayBoard.copy().getBoard();
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[x].length; y++) {
                    if (board[x][y].isStateSwitching(conwayBoard.getNeighborCellStates(board[x][y]))) {
                        newBoard[x][y].switchState();
                    }
                }
            }
            conwayBoard.setBoard(newBoard);
        }
    }
}
