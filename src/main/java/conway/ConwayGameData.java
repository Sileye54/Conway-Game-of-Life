package conway;

public class ConwayGameData extends GameData{
    private int numberOfIterations;
    private char[][] boardStructure;

    public ConwayGameData(int numberOfIterations, char boardStructure[][]){
        this.numberOfIterations = numberOfIterations;
        this.boardStructure = boardStructure;
    }
    public int getNumberOfIterations() {
        return numberOfIterations;
    }
    public char[][] getBoardStructure() {
        return boardStructure;
    }

}
