import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.URL;
import java.util.Arrays;

import conway.ConwayBoard;
import conway.ConwayGameArguments;
import conway.InvalidBoardSizeFormatException;
import conway.InvalidBoardFormatException;
import conway.InvalidIterationException;

public class ConwayTest {
  /**
   * Test for invalid iteration exception.
   */
  @Test(expected = InvalidIterationException.class)
  public void invalidIteration() throws Exception {
    URL fileUrl = getClass().getClassLoader().getResource("_examples_test/valid_test.txt");
    String filePath = fileUrl.getPath();
    ConwayGameArguments conwayGameArguments = new ConwayGameArguments();
    conwayGameArguments.loadArguments(new String[] { filePath, "A" });

  }

  /**
   * Test for invalid board size format exception.
   * 
   * @throws Exception
   */
  @Test(expected = InvalidBoardSizeFormatException.class)
  public void invalidBoardSizeFormat() throws Exception {
    URL fileUrl = getClass().getClassLoader().getResource("_examples_test/invalid_size_format.txt");
    String filePath = fileUrl.getPath();
    ConwayGameArguments conwayGameArguments = new ConwayGameArguments();
    conwayGameArguments.loadArguments(new String[] { filePath, "1" });

  }

  /**
   * Test for invalid board columns size exception.
   * 
   * @throws Exception
   */
  @Test(expected = InvalidBoardFormatException.class)
  public void invalidBoardColsSize() throws Exception {
    URL fileUrl = getClass().getClassLoader().getResource("_examples_test/invalid_board_cols_size.txt");
    String filePath = fileUrl.getPath();
    ConwayGameArguments conwayGameArguments = new ConwayGameArguments();
    conwayGameArguments.loadArguments(new String[] { filePath, "1" });

  }

  /**
   * Test for invalid board rows size exception.
   * 
   * @throws Exception
   */
  @Test(expected = InvalidBoardFormatException.class)
  public void invalidBoardRowsSize() throws Exception {
    URL fileUrl = getClass().getClassLoader().getResource("_examples_test/invalid_board_rows_size.txt");
    String filePath = fileUrl.getPath();
    ConwayGameArguments conwayGameArguments = new ConwayGameArguments();
    conwayGameArguments.loadArguments(new String[] { filePath, "1" });

  }

  /**
   * Test for invalid board rows size exception.
   * 
   * @throws Exception
   */
  @Test(expected = InvalidBoardFormatException.class)
  public void invalidBoardRowsSize2() throws Exception {
    URL fileUrl = getClass().getClassLoader().getResource("_examples_test/invalid_board_rows_size2.txt");
    String filePath = fileUrl.getPath();
    ConwayGameArguments conwayGameArguments = new ConwayGameArguments();
    conwayGameArguments.loadArguments(new String[] { filePath, "1" });

  }

  /**
   * Test for invalid board format exception.
   * 
   * @throws Exception
   */
  @Test(expected = InvalidBoardFormatException.class)
  public void invalidBoardFormat() throws Exception {
    URL fileUrl = getClass().getClassLoader().getResource("_examples_test/invalid_board_format.txt");
    String filePath = fileUrl.getPath();
    ConwayGameArguments conwayGameArguments = new ConwayGameArguments();
    conwayGameArguments.loadArguments(new String[] { filePath, "1" });

  }

  /**
   * Test for invalid negative board size exception.
   * 
   * @throws Exception
   */
  @Test(expected = InvalidBoardSizeFormatException.class)
  public void invalid_negative_board_size() throws Exception {
    URL fileUrl = getClass().getClassLoader().getResource("_examples_test/invalid_negative_size.txt");
    String filePath = fileUrl.getPath();
    ConwayGameArguments conwayGameArguments = new ConwayGameArguments();
    conwayGameArguments.loadArguments(new String[] { filePath, "1" });

  }

  /**
   * Test for valid arguments.
   * 
   * @throws Exception
   */
  @Test
  public void validArguments() {
    int expectedNumberOfIteration = 10;
    char[][] expectedBoard = {
        { '_', '_', '_', '_', '_', '_' },
        { '_', '_', 'X', 'X', '_', '_' },
        { '_', 'X', '_', '_', 'X', '_' },
        { '_', '_', 'X', 'X', '_', '_' },
        { '_', '_', '_', '_', '_', '_' },
        { '_', '_', '_', '_', '_', '_' }
    };
    URL fileUrl = getClass().getClassLoader().getResource("_examples_test/valid_arguments_test.txt");
    String filePath = fileUrl.getPath();
    ConwayGameArguments conwayGameArguments = new ConwayGameArguments();
    try {
      conwayGameArguments.loadArguments(new String[] { filePath, "10" });
      char actualBoard[][] = conwayGameArguments.getBoardStructure();
      int actualNumberOfIteration = conwayGameArguments.getNumberOfIterations();
      assertTrue(actualNumberOfIteration == expectedNumberOfIteration);
      assertTrue(Arrays.deepEquals(expectedBoard, actualBoard));
    } catch (Exception e) {
    }

  }

  /**
   * Test for valid simulation.
   * 
   * @throws Exception
   */
  @Test
  public void validSimulation() {
    URL fileUrl = getClass().getClassLoader().getResource("_examples_test/valid_test.txt");
    String filePath = fileUrl.getPath();
    ConwayGameArguments conwayGameArguments = new ConwayGameArguments();
    try {
      conwayGameArguments.loadArguments(new String[] { filePath, "6" });
      ConwayBoard conwayBoard = new ConwayBoard();
      conwayBoard.initializeBoard(conwayGameArguments);
      ConwayBoard initialBoard = conwayBoard.copy();
      conwayBoard.simulate();
      assertTrue(initialBoard.isEqual(conwayBoard));
    } catch (Exception e) {
      fail();
      ;
    }

  }
}