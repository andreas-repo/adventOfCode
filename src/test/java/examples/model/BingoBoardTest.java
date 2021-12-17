package examples.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BingoBoardTest {

    private static final Integer[] TRUE_VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
    private static final Integer[] FALSE_VALUES = {0, -1, 26, 999};
    private BingoBoard bingoBoard;

    @BeforeEach
    void init() {
        this.bingoBoard = new BingoBoard();
    }

    @Test
    @DisplayName("When board contains value then returns true")
    void containsNumber_whenBoardContainsNumber_thenReturnsTrue() {
        this.fillTestBingoBoard();

        assertThat(this.bingoBoard.containsNumber(20))
                .isTrue();
    }

    @Test
    @DisplayName("When board doesnt contain value then returns false")
    void containsNumber_whenBoardDoesntContainNumber_thenReturnsFalse() {
        this.fillTestBingoBoard();

        assertThat(this.bingoBoard.containsNumber(30))
                .isFalse();
    }

    @Test
    @DisplayName("Zero as Argument returns False")
    void containsNumber_whenArgumentIsZero_thenReturnFalse() {
        this.fillTestBingoBoard();

        assertThat(this.bingoBoard.containsNumber(0))
                .isFalse();
    }

    @ParameterizedTest
    @MethodSource("trueValueSource")
    @DisplayName("Contained values return true")
    void containsNumber_whenArgumentIsContained_thenReturnsTrue(int testData) {
        this.fillTestBingoBoard();

        assertThat(this.bingoBoard.containsNumber(testData))
                .isTrue();
    }

    static Stream<Integer> trueValueSource() {
        return Stream.of(TRUE_VALUES);
    }

    @ParameterizedTest
    @MethodSource("falseValueSource")
    @DisplayName("Not contained and false value return false")
    void containsNumber_whenArgumentIsNotContained_thenReturnsFalse(int testData) {
        this.fillTestBingoBoard();

        assertThat(this.bingoBoard.containsNumber(testData))
                .isFalse();
    }

    @Test
    void hasBoardWon_whenFirstLineIsMarked_thenReturnsTrue() {
        this.fillTestBingoBoard();
        List<Integer> drawenNumbers = getMarkedFirstLine();
        drawenNumbers.forEach(this.bingoBoard::containsNumber);

        assertThat(this.bingoBoard.hasBoardWon())
                .isTrue();
    }

    @Test
    void hasBoardWon_whenSecondLineIsMarked_thenReturnsTrue() {
        this.fillTestBingoBoard();
        List<Integer> drawenNumbers = getMarkedSecondLine();
        drawenNumbers.forEach(this.bingoBoard::containsNumber);

        assertThat(this.bingoBoard.hasBoardWon())
                .isTrue();
    }

    @Test
    void hasBoardWon_whenThirdLineIsMarked_thenReturnsTrue() {
        this.fillTestBingoBoard();
        List<Integer> drawenNumbers = getMarkedThirdLine();
        drawenNumbers.forEach(this.bingoBoard::containsNumber);

        assertThat(this.bingoBoard.hasBoardWon())
                .isTrue();
    }

    @Test
    void hasBoardWon_whenFourthLineIsMarked_thenReturnsTrue() {
        this.fillTestBingoBoard();
        List<Integer> drawenNumbers = getMarkedFourthLine();
        drawenNumbers.forEach(this.bingoBoard::containsNumber);

        assertThat(this.bingoBoard.hasBoardWon())
                .isTrue();
    }

    @Test
    void hasBoardWon_whenFiftiethLineIsMarked_thenReturnsTrue() {
        this.fillTestBingoBoard();
        List<Integer> drawenNumbers = getMarkedFiftieththLine();
        drawenNumbers.forEach(this.bingoBoard::containsNumber);

        assertThat(this.bingoBoard.hasBoardWon())
                .isTrue();
    }

    @Test
    void hasBoardWon_whenFirstVerticalLineIsMarked_thenReturnsTrue() {
        this.fillTestBingoBoard();
        List<Integer> drawenNumbers = getMarkedFirstVerticalLine();
        drawenNumbers.forEach(this.bingoBoard::containsNumber);

        assertThat(this.bingoBoard.hasBoardWon())
                .isTrue();
    }

    @Test
    void hasBoardWon_whenSecondVerticalLineIsMarked_thenReturnsTrue() {
        this.fillTestBingoBoard();
        List<Integer> drawenNumbers = getMarkedSecondVerticalLine();
        drawenNumbers.forEach(this.bingoBoard::containsNumber);

        assertThat(this.bingoBoard.hasBoardWon())
                .isTrue();
    }

    @Test
    void hasBoardWon_whenThirdVerticalLineIsMarked_thenReturnsTrue() {
        this.fillTestBingoBoard();
        List<Integer> drawenNumbers = getMarkedThirdVerticalLine();
        drawenNumbers.forEach(this.bingoBoard::containsNumber);

        assertThat(this.bingoBoard.hasBoardWon())
                .isTrue();
    }

    @Test
    void hasBoardWon_whenFourthVerticalLineIsMarked_thenReturnsTrue() {
        this.fillTestBingoBoard();
        List<Integer> drawenNumbers = getMarkedFourthVerticalLine();
        drawenNumbers.forEach(this.bingoBoard::containsNumber);

        assertThat(this.bingoBoard.hasBoardWon())
                .isTrue();
    }

    @Test
    void hasBoardWon_whenFiftiethVerticalLineIsMarked_thenReturnsTrue() {
        this.fillTestBingoBoard();
        List<Integer> drawenNumbers = getMarkedFiftiethVerticalLine();
        drawenNumbers.forEach(this.bingoBoard::containsNumber);

        assertThat(this.bingoBoard.hasBoardWon())
                .isTrue();
    }

    static Stream<Integer> falseValueSource() {
        return Stream.of(FALSE_VALUES);
    }

    private void fillTestBingoBoard() {
        List<BingoNumber> testBingoNumbers = new ArrayList<>();

        for(int i = 1; i <= 25; i++) {
            BingoNumber bingoNumber = new BingoNumber(i, i);
            testBingoNumbers.add(bingoNumber);
        }
        this.bingoBoard.setBoard(testBingoNumbers);
    }

    private List<Integer> getMarkedFirstLine() {
        Integer number1 = 1;
        Integer number2 = 2;
        Integer number3 = 3;
        Integer number4 = 4;
        Integer number5 = 5;
        return List.of(number1, number2, number3, number4, number5);
    }

    private List<Integer> getMarkedSecondLine() {
        Integer number1 = 6;
        Integer number2 = 7;
        Integer number3 = 8;
        Integer number4 = 9;
        Integer number5 = 10;
        return List.of(number1, number2, number3, number4, number5);
    }

    private List<Integer> getMarkedThirdLine() {
        Integer number1 = 11;
        Integer number2 = 12;
        Integer number3 = 13;
        Integer number4 = 14;
        Integer number5 = 15;
        return List.of(number1, number2, number3, number4, number5);
    }

    private List<Integer> getMarkedFourthLine() {
        Integer number1 = 16;
        Integer number2 = 17;
        Integer number3 = 18;
        Integer number4 = 19;
        Integer number5 = 20;
        return List.of(number1, number2, number3, number4, number5);
    }

    private List<Integer> getMarkedFiftieththLine() {
        Integer number1 = 21;
        Integer number2 = 22;
        Integer number3 = 23;
        Integer number4 = 24;
        Integer number5 = 25;
        return List.of(number1, number2, number3, number4, number5);
    }

    private List<Integer> getMarkedFirstVerticalLine() {
        Integer number1 = 1;
        Integer number2 = 6;
        Integer number3 = 11;
        Integer number4 = 16;
        Integer number5 = 21;
        return List.of(number1, number2, number3, number4, number5);
    }

    private List<Integer> getMarkedSecondVerticalLine() {
        Integer number1 = 2;
        Integer number2 = 7;
        Integer number3 = 12;
        Integer number4 = 17;
        Integer number5 = 22;
        return List.of(number1, number2, number3, number4, number5);
    }

    private List<Integer> getMarkedThirdVerticalLine() {
        Integer number1 = 3;
        Integer number2 = 8;
        Integer number3 = 13;
        Integer number4 = 18;
        Integer number5 = 23;
        return List.of(number1, number2, number3, number4, number5);
    }

    private List<Integer> getMarkedFourthVerticalLine() {
        Integer number1 = 4;
        Integer number2 = 9;
        Integer number3 = 14;
        Integer number4 = 19;
        Integer number5 = 24;
        return List.of(number1, number2, number3, number4, number5);
    }

    private List<Integer> getMarkedFiftiethVerticalLine() {
        Integer number1 = 4;
        Integer number2 = 9;
        Integer number3 = 14;
        Integer number4 = 19;
        Integer number5 = 24;
        return List.of(number1, number2, number3, number4, number5);
    }
}
