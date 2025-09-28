package conway;

abstract class GameArguments {
  /**
   * Loads the game arguments from the command line.
   *
   * @param args the command line arguments
   * @throws Exception if the arguments are invalid
   */
  abstract void loadArguments(String args[]) throws Exception;
}
