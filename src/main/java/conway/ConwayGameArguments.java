package conway;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

/**
 * Class to handle game arguments for Conway's Game of Life.
 */
public class ConwayGameArguments extends GameArguments {
  private int numberOfIterations;
  private char[][] boardStructure;

  @Override
  public void loadArguments(String[] args) throws Exception {
    numberOfIterations = extractNumberOfIteration(args[1]);
    boardStructure = extractBoardStructure(args[0]);

  }

  /**
   * Get the number of iterations for the game.
   * 
   * @return number of iterations
   */
  public int getNumberOfIterations() {
    return numberOfIterations;
  }

  /**
   * Get the board structure for the game.
   * 
   * @return board structure as a 2D char array
   */
  public char[][] getBoardStructure() {
    return boardStructure;
  }

  /**
   * Extracts the board structure from a file.
   * 
   * @param filePath path to the file containing the board structure
   * @return 2D char array representing the board structure
   * @throws Exception if there is an error reading the file or if the format is
   *                   invalid
   */
  private char[][] extractBoardStructure(String filePath) throws Exception {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      int boardSize = extractBoardSize(reader.readLine().trim());
      char[][] board = readBoard(reader, boardSize);
      return board;
    } catch (IOException e) {
      throw new IOException("Erreur de lecture du fichier", e);
    }
  }

  /**
   * Reads the board structure from a BufferedReader.
   * 
   * @param reader    BufferedReader to read the board structure from
   * @param boardSize expected size of the board (number of rows and columns)
   * @return 2D char array representing the board structure
   * @throws Exception if the format is invalid
   */
  private char[][] readBoard(BufferedReader reader, int boardSize) throws Exception {
    char[][] board = new char[boardSize][boardSize];
    String line;
    int row = 0;

    while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {
      String[] cols = line.trim().split(" ");
      if (row >= boardSize) {
        throw new InvalidBoardFormatException("Le nombre de lignes est inferieur a la taille founie");
      }
      if (cols.length != boardSize) {
        throw new InvalidBoardFormatException("Le nombre de colonnes est invalide à la ligne " + (row + 1));
      }
      for (int col = 0; col < cols.length; col++) {
        validateCell(cols[col]);
        board[row][col] = cols[col].charAt(0);
      }
      row++;
    }

    if (row != boardSize) {
      throw new InvalidBoardFormatException("Le nombre de lignes est superieur a la taille fournie");
    }
    return board;
  }

  /**
   * Validates a cell character.
   * 
   * @param cell character to validate
   * @throws InvalidBoardFormatException if the cell character is invalid
   */
  private void validateCell(String cell) throws InvalidBoardFormatException {
    if (!cell.equals("X") && !cell.equals("_")) {
      throw new InvalidBoardFormatException("Cellule invalide : " + cell);
    }
  }

  /**
   * Extracts a positive integer from a string.
   * 
   * @param arg               string to extract the integer from
   * @param fieldName         name of the field for error messages
   * @param exceptionSupplier function to create an exception if the format is
   *                          invalid
   * @return extracted positive integer
   * @throws E if the format is invalid or if the integer is negative
   */
  private <E extends Exception> int extractPositiveInt(String arg, String fieldName,
      Function<String, E> exceptionSupplier) throws E {
    int value;
    try {
      value = Integer.parseInt(arg);
      if (value < 0) {
        throw exceptionSupplier.apply("Le " + fieldName + " doit être positif");
      }
    } catch (NumberFormatException e) {
      throw exceptionSupplier.apply("Format invalide pour " + fieldName);
    }
    return value;
  }

  /**
   * Extracts the number of iterations from a string.
   * 
   * @param arg string to extract the number of iterations from
   * @return extracted number of iterations
   * @throws InvalidIterationException if the format is invalid or if the number
   *                                   is negative
   */
  public int extractNumberOfIteration(String arg) throws InvalidIterationException {
    return extractPositiveInt(arg, "nombre d’itérations", InvalidIterationException::new);
  }

  /**
   * Extracts the board size from a string.
   * 
   * @param arg string to extract the board size from
   * @return extracted board size
   * @throws InvalidBoardSizeFormatException if the format is invalid or if the
   *                                         size is negative
   */
  public int extractBoardSize(String arg) throws InvalidBoardSizeFormatException {
    return extractPositiveInt(arg, "taille du plateau", InvalidBoardSizeFormatException::new);
  }

}
