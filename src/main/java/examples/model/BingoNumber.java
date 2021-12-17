package examples.model;

public class BingoNumber {

    private Integer number;
    private Integer placeOnBoard;
    private boolean isMarked = false;

    public BingoNumber() {}
    public BingoNumber(Integer number, Integer placeOnBoard) {
        this.number = number;
        this.placeOnBoard = placeOnBoard;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPlaceOnBoard() {
        return placeOnBoard;
    }

    public void setPlaceOnBoard(Integer placeOnBoard) {
        this.placeOnBoard = placeOnBoard;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }

    @Override
    public String toString() {
        return "BingoNumber{" +
                "number=" + number +
                ", placeOnBoard=" + placeOnBoard +
                ", isMarked=" + isMarked +
                '}';
    }
}
