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
    conwayGameArguments.loadArguments(args);
    char[][] boardStructure = conwayGameArguments.getBoardStructure();
    conwayBoard = new ConwayBoard();
    conwayBoard.initializeBoard(boardStructure);

  }

  public void run() {

    try {

      ConwaySimulator conwaySimulator = new ConwaySimulator();
      int numberOfIterations = conwayGameArguments.getNumberOfIterations();

      conwaySimulator.simulate(conwayBoard, numberOfIterations);
      conwayBoard.printBoard();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}
