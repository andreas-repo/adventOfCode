package examples.model;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class BingoBoard {

    List<BingoNumber> board;

    public BingoBoard() {}
    public BingoBoard(List<BingoNumber> board) {
        this.board = board;
    }

    public List<BingoNumber> getBoard() {
        return board;
    }

    public void setBoard(List<BingoNumber> board) {
        this.board = board;
    }

    public void addBingoNumberToBoard(BingoNumber bingoNumber) {
        this.board.add(bingoNumber);
    }

    public boolean containsNumber(int number) {
        AtomicBoolean containsNumber = new AtomicBoolean(false);
        board.forEach(bingoNumber -> {
            if (bingoNumber.getNumber() == number) {
                containsNumber.set(true);
            }
        });

        return containsNumber.get();
    }

    @Override
    public String toString() {
        return "BingoBoard{" +
                "board=" + board +
                '}';
    }
}
