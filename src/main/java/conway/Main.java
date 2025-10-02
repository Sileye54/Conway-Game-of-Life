package conway;

/** The main class */
public class Main {
  public static void main(String[] args) {
    Conway conway = new Conway();
    try {
      conway.initializeGame(args);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    conway.run();
  }
}
