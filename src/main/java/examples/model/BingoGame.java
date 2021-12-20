package examples.model;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class BingoGame {

    public BingoBoard findFirstWinningBoard(List<BingoBoard> bingoBoards, List<Integer> drawnNumbers) {
        BingoBoard winningBoard = new BingoBoard();
        AtomicBoolean hasWon = new AtomicBoolean(false);

        for (int number : drawnNumbers) {
            bingoBoards.forEach(board -> {
                board.containsNumber(number);
                if(board.hasBoardWon()) {
                    hasWon.set(true);
                }
            });

            for (BingoBoard board : bingoBoards) {
                if (board.hasBoardWon()) {
                    winningBoard = board;
                    break;
                }
            }
        }

        return winningBoard;
    }

    public boolean playBingo(BingoBoard bingoBoard, List<Integer> drawnNumbers) {
        drawnNumbers.forEach(bingoBoard::containsNumber);
        return bingoBoard.hasBoardWon();
    }
}
