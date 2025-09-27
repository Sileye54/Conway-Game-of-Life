import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.Arrays;
import conway.ConwayGameArguments;
import conway.ConwayGameData;
import conway.InvalidBoardSizeException;
import conway.InvalidBoardFormatException;
import conway.InvalidIterationException;
public class ConwayGameArgumentsTest {
  
    @Test(expected = InvalidIterationException.class)
    public void invalidIteration() throws Exception{
      URL fileUrl = getClass().getClassLoader().getResource("_examples_test/valid_test.txt");
      String filePath = fileUrl.getPath();
      ConwayGameArguments conwayGameArguments = new ConwayGameArguments();
      conwayGameArguments.loadArguments(new String[]{filePath,"A"});
        
    }
     @Test (expected = InvalidBoardSizeException.class)
    public void invalidBoardSizeFormat () throws Exception{
      URL fileUrl = getClass().getClassLoader().getResource("_examples_test/invalid_size_format.txt");
      String filePath = fileUrl.getPath();
      ConwayGameArguments conwayGameArguments = new ConwayGameArguments();
      conwayGameArguments.loadArguments(new String[]{filePath,"1"});
    
    }
     @Test (expected = InvalidBoardFormatException.class)
    public void invalidBoardSize () throws Exception{
      URL fileUrl = getClass().getClassLoader().getResource("_examples_test/invalid_board_size.txt");
      String filePath = fileUrl.getPath();
      ConwayGameArguments conwayGameArguments = new ConwayGameArguments();
      conwayGameArguments.loadArguments(new String[]{filePath,"1"});
    
    }
    @Test (expected = InvalidBoardFormatException.class)
    public void invalidBoardFormat () throws Exception{
      URL fileUrl = getClass().getClassLoader().getResource("_examples_test/invalid_board.txt");
      String filePath = fileUrl.getPath();
      ConwayGameArguments conwayGameArguments = new ConwayGameArguments();
      conwayGameArguments.loadArguments(new String[]{filePath,"1"});
    
    }
    @Test
    public void validArguments(){
      int expectedNumberOfIteration = 10;
      char[][] expectedBoard = {
            {'_', '_', '_', '_', '_', '_'},
            {'_', '_', 'X', 'X', '_', '_'},
            {'_', 'X', '_', '_', 'X', '_'},
            {'_', '_', 'X', 'X', '_', '_'},
            {'_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_'}
        };
      URL fileUrl = getClass().getClassLoader().getResource("_examples_test/valid_test.txt");
      String filePath = fileUrl.getPath();
      ConwayGameArguments conwayGameArguments = new ConwayGameArguments();
      try {
        conwayGameArguments.loadArguments(new String[]{filePath,"10"}) ;
        ConwayGameData conwayGameData = conwayGameArguments.getArguments();
        char actualBoard[][] = conwayGameData.getBoardStructure();
        int actualNumberOfIteration = conwayGameData.getNumberOfIterations(); 
        assertTrue(actualNumberOfIteration == expectedNumberOfIteration);
        assertTrue(Arrays.deepEquals(expectedBoard, actualBoard));
      } catch (Exception e) {} 
      
    }
  }