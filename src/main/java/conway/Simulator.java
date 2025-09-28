package conway;

public interface Simulator<T extends Board> {
  /**
   * Simulates the board for a given number of iterations.
   * 
   * @param board              the board to simulate
   * @param numberOfIterations the number of iterations to simulate
   */
  void simulate(T board, int numberOfIterations);
}
