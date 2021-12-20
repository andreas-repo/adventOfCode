package examples.model;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class BingoBoard {

    private List<BingoNumber> board;
    private int lastMarkedNumber;


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
                if (!this.hasBoardWon()) {
                    containsNumber.set(true);
                    bingoNumber.setMarked(true);
                    lastMarkedNumber = number;
                }
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

    public int getAmountOfMarkedNumbers() {
        AtomicInteger amount = new AtomicInteger();

        this.board.forEach(number -> {
            if (number.isMarked()) {
                amount.getAndIncrement();
            }
        });

        return amount.get();
    }

    public int getSumOfAllUnmarkedNumbers() {
        AtomicInteger amount = new AtomicInteger();
        this.board.forEach(number -> {
            if(!number.isMarked()) {
                amount.set(amount.get() + number.getNumber());
            }
        });

        return amount.get();
    }

    public int getLastMarkedNumber() {
        return lastMarkedNumber;
    }

    public void setLastMarkedNumber(int lastMarkedNumber) {
        this.lastMarkedNumber = lastMarkedNumber;
    }

    public boolean compare(Object o) {
        if (o == null) return false;
        BingoBoard that = (BingoBoard) o;
        return this.lastMarkedNumber == that.lastMarkedNumber && this.board.toString().equals(that.board.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BingoBoard that = (BingoBoard) o;
        return lastMarkedNumber == that.lastMarkedNumber && Objects.equals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board, lastMarkedNumber);
    }

    @Override
    public String toString() {
        return "BingoBoard{" +
                "board=" + board +
                ", lastMarkedNumber=" + lastMarkedNumber +
                '}';
    }
}
