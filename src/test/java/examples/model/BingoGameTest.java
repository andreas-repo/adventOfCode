package examples.model;

import examples.helper.FormatInput;
import examples.input.ReadFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BingoGameTest {

    private BingoGame bingoGame;

    @BeforeEach
    void init() {
        bingoGame = new BingoGame();
    }

    @Test
    @DisplayName("Tests for correct value when bingo board wins")
    void playBingo_whenBoardWins_thenReturnTrue() {
        boolean result = bingoGame.playBingo(getWinningTestBoard(), getMarkedFirstLine());

        assertThat(result)
                .isTrue();
    }

    @Test
    @DisplayName("Tests for false return value when bingo board has not won")
    void playBingo_whenBoardLost_thenReturnsFalse() {
        boolean result = bingoGame.playBingo(getLossingTestBoard(), getLoosingNumbers());

        assertThat(result)
                .isFalse();
    }

    @Test
    void findFirstWinningBoard_whenFirstBoardWins_thenReturnsCorrectWinningBoard() {
        BingoBoard result = bingoGame.findFirstWinningBoard(getListWithFirstBoardWinning(), getMarkedFirstLine());

        //Expected
        BingoBoard expected = getWinningTestBoard();
        getMarkedFirstLine().forEach(expected::containsNumber);

        assertThat(result.compare(expected))
                .isTrue();
    }

    @Test
    void findFirstWinningBoard_whenFirstBoardWinsAndAnotherBoardWinsLater_thenReturnsCorrectWinningBoard() {
        List<BingoBoard> list = getListWithTwoWinningBoards();
        BingoBoard result = bingoGame.findFirstWinningBoard(list, getMarkedFirstLine());

        //Expected
        BingoBoard expected = list.get(0);
        //Not expected
        BingoBoard notExpected = list.get(3);

        assertThat(result.equals(notExpected))
                .isFalse();
        assertThat(result.equals(expected))
                .isTrue();
    }

    @Test
    void test() {
        List<BingoBoard> boards = getExampleBoards();
        List<Integer> drawnNumbers = getAllDrawnNumbers();

        BingoBoard result = bingoGame.findFirstWinningBoard(boards, drawnNumbers);

        assertThat(result.getLastMarkedNumber())
                .isEqualTo(24);
        assertThat(result.getSumOfAllUnmarkedNumbers())
                .isEqualTo(188);
    }

    private List<BingoBoard> getExampleBoards() {
        ReadFile readFile = new ReadFile();
        readFile.setFilePath("C:\\Users\\andre\\Development\\Projekte\\adventOfCode\\testBoards.txt");
        List<String> inputBingoBoards = readFile.readInputText();
        List<BingoBoard> boards =  FormatInput.getAllPlacesOnBoard(inputBingoBoards);
        return boards;
    }

    private List<Integer> getAllDrawnNumbers() {
        ReadFile readFile = new ReadFile();
        readFile.setFilePath("C:\\Users\\andre\\Development\\Projekte\\adventOfCode\\testNumbers.txt");
        List<String> inputDrawnNumbers = readFile.readInputText();
        return FormatInput.toDrawnNumbersList(inputDrawnNumbers);
    }

    private List<BingoBoard> getListWithFirstBoardWinning() {
        return List.of(getWinningTestBoard(), getLossingTestBoard(), getLossingTestBoard());
    }

    private List<BingoBoard> getListWithTwoWinningBoards() {
        List<BingoNumber> testBingoNumbers = new ArrayList<>();

        for(int i = 1; i <= 25; i++) {
            BingoNumber bingoNumber = new BingoNumber(i, i);
            testBingoNumbers.add(bingoNumber);
        }
        BingoBoard board = new BingoBoard(testBingoNumbers);

        return List.of(getWinningTestBoard(), getLossingTestBoard(), getLossingTestBoard(), board);
    }

    private BingoBoard getWinningTestBoard() {
        List<BingoNumber> testBingoNumbers = new ArrayList<>();

        for(int i = 1; i <= 25; i++) {
            BingoNumber bingoNumber = new BingoNumber(i, i);
            testBingoNumbers.add(bingoNumber);
        }
        return new BingoBoard(testBingoNumbers);
    }

    private BingoBoard getLossingTestBoard() {
        List<BingoNumber> testBingoNumbers = new ArrayList<>();

        for(int i = 1; i <= 25; i++) {
            BingoNumber bingoNumber = new BingoNumber(i, i);
            testBingoNumbers.add(bingoNumber);
        }
        return new BingoBoard(testBingoNumbers);
    }

    private List<Integer> getMarkedFirstLine() {
        Integer number1 = 1;
        Integer number2 = 2;
        Integer number3 = 3;
        Integer number4 = 4;
        Integer number5 = 5;
        return List.of(number1, number2, number3, number4, number5);
    }

    private List<Integer> getLoosingNumbers() {
        Integer number1 = 1;
        Integer number2 = 11;
        Integer number3 = 3;
        Integer number4 = 4;
        Integer number5 = 5;
        return List.of(number1, number2, number3, number4, number5);
    }
}
