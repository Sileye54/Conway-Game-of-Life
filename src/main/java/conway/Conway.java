package conway;

public class Conway {
  /**
   * Runs the Conway's Game of Life.
   * 
   * @param args command line arguments
   */
  public static void run(String[] args) {
    ConwayGameArguments conwayGameArguments = new ConwayGameArguments();
    try {
      conwayGameArguments.loadArguments(args);
      char[][] boardStructure = conwayGameArguments.getBoardStructure();
      int numberOfIterations = conwayGameArguments.getNumberOfIterations();
      ConwayBoard conwayBoard = new ConwayBoard();
      conwayBoard.initializeBoard(boardStructure);
      ConwaySimulator conwaySimulator = new ConwaySimulator();
      conwaySimulator.simulate(conwayBoard, numberOfIterations);
      conwayBoard.printBoard();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
