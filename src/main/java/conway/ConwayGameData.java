package conway;

public class ConwayGameData extends GameData{
    private int numberOfIterations;
    private char[][] boardStructure;
    private int boardSize;

    public ConwayGameData(int numberOfIterations, char boardStructure[][]){
        this.numberOfIterations = numberOfIterations;
        this.boardStructure = boardStructure;
        this.boardSize = boardStructure.length;
    }
    public int getNumberOfIterations() {
        return numberOfIterations;
    }
    public char[][] getBoardStructure() {
        return boardStructure;
    }
    public int getBoardSize(){
        return boardSize;
    }

}
