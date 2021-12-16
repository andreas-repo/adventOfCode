package examples.model;

import java.util.List;

public class BingoBoard {

    List<Integer> board;

    public BingoBoard() {}
    public BingoBoard(List<Integer> board) {
        this.board = board;
    }

    public List<Integer> getBoard() {
        return board;
    }

    public void setBoard(List<Integer> board) {
        this.board = board;
    }

    public boolean containsNumber(int number) {
         return this.board.contains(number);
    }

    @Override
    public String toString() {
        return "BingoBoard{" +
                "board=" + board +
                '}';
    }
}
