package conway;

public class Conway {
  /**
   * Runs the Conway's Game of Life.
   * 
   * @param args command line arguments
   */
  private ConwayGameArguments conwayGameArguments;

  private ConwayBoard conwayBoard;

  public void initializeGame(String[] args) throws Exception {
    conwayGameArguments = new ConwayGameArguments();
    conwayBoard = new ConwayBoard();
    conwayBoard.initializeBoard(conwayGameArguments);

  }

  public void run() {

    try {
      conwayBoard.simulate();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    conwayBoard.printBoard();
  }

}
