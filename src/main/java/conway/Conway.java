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
      ConwayBoard conwayBoard = new ConwayBoard(conwayGameArguments.getBoardStructure());
      ConwaySimulator conwaySimulator = new ConwaySimulator();
      conwaySimulator.simulate(conwayBoard, conwayGameArguments.getNumberOfIterations());
      conwayBoard.printBoard();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
