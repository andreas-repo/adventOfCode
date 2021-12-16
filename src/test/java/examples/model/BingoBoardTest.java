package examples.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BingoBoardTest {

    BingoBoard bingoBoard;

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
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25})
    @DisplayName("Contained values return true")
    void containsNumber_whenArgumentIsContained_thenReturnsTrue(int testData) {
        this.fillTestBingoBoard();

        assertThat(this.bingoBoard.containsNumber(testData))
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 26, 999})
    @DisplayName("Not contained and false value return false")
    void containsNumber_whenArgumentIsNotContained_thenReturnsFalse(int testData) {
        this.fillTestBingoBoard();

        assertThat(this.bingoBoard.containsNumber(testData))
                .isFalse();
    }

    private void fillTestBingoBoard() {
        List<Integer> testData = new ArrayList<>();
        for(int i = 1; i <= 25; i++) {
            testData.add(i);
        }
        this.bingoBoard.setBoard(testData);
    }
}
