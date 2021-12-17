package examples.model;

import java.util.List;

public class BingoGame {
    private List<Integer> drawedNumbers;
    private List<BingoBoard> bingoBoardList;
    private BingoBoard winningBoard;

    public boolean playBingo(BingoBoard bingoBoard, List<Integer> drawedNumbers) {
        drawedNumbers.forEach(bingoBoard::containsNumber);
        return bingoBoard.hasBoardWon();
    }

    public List<Integer> getDrawedNumbers() {
        return drawedNumbers;
    }

    public void setDrawedNumbers(List<Integer> drawedNumbers) {
        this.drawedNumbers = drawedNumbers;
    }

    public List<BingoBoard> getBingoBoardList() {
        return bingoBoardList;
    }

    public void setBingoBoardList(List<BingoBoard> bingoBoardList) {
        this.bingoBoardList = bingoBoardList;
    }

    public BingoBoard getWinningBoard() {
        return winningBoard;
    }

    public void setWinningBoard(BingoBoard winningBoard) {
        this.winningBoard = winningBoard;
    }
}
