package conway;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

public class ConwayGameArguments implements GameArguments {
    private int numberOfIterations;
    private char[][] boardStructure;

    @Override
  public void loadArguments(String[] args) throws Exception {
    numberOfIterations = extractNumberOfIteration(args[1]);
    boardStructure = extractBoardStructure(args[0]);

  }

  @Override
  public ConwayGameData getArguments() {
    return new ConwayGameData(numberOfIterations,boardStructure);
  }

  public char[][] extractBoardStructure(String filePath) throws Exception {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        int boardSize = extractBoardSize(reader.readLine().trim());
        char[][] board = readBoard(reader, boardSize);
        validateBoard(board, boardSize);
        return board;
    } catch (IOException e) {
        throw new IOException("Erreur de lecture du fichier", e);
    }
}

private char[][] readBoard(BufferedReader reader, int boardSize) throws Exception {
    char[][] board = new char[boardSize][boardSize];
    String line;
    int row = 0;

    while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {
        String[] cols = line.trim().split(" ");
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
        throw new InvalidBoardFormatException("Le nombre de lignes est invalide");
    }
    return board;
}

private void validateCell(String cell) throws InvalidBoardFormatException {
    if (!cell.equals("X") && !cell.equals("_")) {
        throw new InvalidBoardFormatException("Cellule invalide : " + cell);
    }
}

private void validateBoard(char[][] board, int expectedSize) throws InvalidBoardFormatException {
    if (board.length != expectedSize || board[0].length != expectedSize) {
        throw new InvalidBoardFormatException("La taille fournie est différente de la taille réelle du plateau");
    }
}

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

    public int extractNumberOfIteration(String arg) throws InvalidIterationException {
        return extractPositiveInt(arg, "nombre d’itérations", InvalidIterationException::new);
    }

    public int extractBoardSize(String arg) throws InvalidBoardSizeException {
        return extractPositiveInt(arg, "taille du plateau", InvalidBoardSizeException::new);
    }

}

