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
                bingoNumber.setMarked(true);
            }
        });

        return containsNumber.get();
    }

    public boolean hasBoardWon() {
        if (board.get(0).isMarked() && board.get(1).isMarked() && board.get(2).isMarked() && board.get(3).isMarked() && board.get(4).isMarked()) {
            return true;
        }
        if (board.get(5).isMarked() && board.get(6).isMarked() && board.get(7).isMarked() && board.get(8).isMarked() && board.get(9).isMarked()) {
            return true;
        }
        if (board.get(10).isMarked() && board.get(11).isMarked() && board.get(12).isMarked() && board.get(13).isMarked() && board.get(14).isMarked()) {
            return true;
        }
        if (board.get(15).isMarked() && board.get(16).isMarked() && board.get(17).isMarked() && board.get(18).isMarked() && board.get(19).isMarked()) {
            return true;
        }
        if (board.get(20).isMarked() && board.get(21).isMarked() && board.get(22).isMarked() && board.get(23).isMarked() && board.get(24).isMarked()) {
            return true;
        }

        if (board.get(0).isMarked() && board.get(5).isMarked() && board.get(10).isMarked() && board.get(15).isMarked() && board.get(20).isMarked()) {
            return true;
        }
        if (board.get(1).isMarked() && board.get(6).isMarked() && board.get(11).isMarked() && board.get(16).isMarked() && board.get(21).isMarked()) {
            return true;
        }
        if (board.get(2).isMarked() && board.get(7).isMarked() && board.get(12).isMarked() && board.get(17).isMarked() && board.get(22).isMarked()) {
            return true;
        }
        if (board.get(3).isMarked() && board.get(8).isMarked() && board.get(13).isMarked() && board.get(18).isMarked() && board.get(23).isMarked()) {
            return true;
        }
        if (board.get(4).isMarked() && board.get(9).isMarked() && board.get(14).isMarked() && board.get(19).isMarked() && board.get(24).isMarked()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "BingoBoard{" +
                "board=" + board +
                '}';
    }
}
