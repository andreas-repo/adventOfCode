package examples;

import examples.helper.FormatInput;
import examples.input.ReadFile;
import examples.model.BingoBoard;
import examples.model.BingoGame;
import examples.model.Submarine;
import examples.model.TwelveBits;

import java.util.List;

import static examples.helper.BinaryConverter.convertToDecimal;

public class Main {
    public static void main(String[] args) {

        ReadFile readFile = new ReadFile("C:\\Users\\andre\\Development\\Projekte\\adventOfCode\\inputtext.txt");

        readFile.setFilePath("C:\\Users\\andre\\Development\\Projekte\\adventOfCode\\diagnosticReport.txt");

        List<String> inputReport = readFile.readInputText();
        System.out.println(inputReport);
        List<TwelveBits> inputBits = FormatInput.toTwelveBit(inputReport);
        //System.out.println(inputBits.toString());

        Submarine submarine = new Submarine();
        submarine.calculatePowerConsumption(inputBits);
        System.out.println(submarine.getConsumptionRate());

        submarine.calculateOxygenGeneratorRating(inputBits);
        System.out.println(submarine.getOxygenGeneratorRating());
        System.out.println(convertToDecimal(submarine.getOxygenGeneratorRating()));
        submarine.calculateCarbonDioxideScrubberRating(inputBits);
        System.out.println(submarine.getCarbonDioxideScrubberRating());
        System.out.println(convertToDecimal(submarine.getCarbonDioxideScrubberRating()));

        readFile.setFilePath("C:\\Users\\andre\\Development\\Projekte\\adventOfCode\\bingoNumbers.txt");
        List<String> inputStringBingoNumbers = readFile.readInputText();
        List<Integer> inputBingoNumbers = FormatInput.toBingoBoardList(inputStringBingoNumbers);
        System.out.println(inputBingoNumbers);

        readFile.setFilePath("C:\\Users\\andre\\Development\\Projekte\\adventOfCode\\bingoBoards.txt");
        List<String> inputStringBingoBoards = readFile.readInputText();
        List<BingoBoard> inputBingo = FormatInput.getAllPlacesOnBoard(inputStringBingoBoards);
        System.out.println(inputBingo);
        System.out.println(inputBingo.size());

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println(" ");

        Integer number1 = inputBingoNumbers.get(0);
        Integer number2 = inputBingoNumbers.get(1);
        Integer number3 = inputBingoNumbers.get(2);
        Integer number4 = inputBingoNumbers.get(3);
        Integer number5 = inputBingoNumbers.get(4);
        List<Integer> firstNumbersList = List.of(number1, number2, number3, number4, number5);
        BingoBoard firstBoard = inputBingo.get(0);
        System.out.println(firstBoard);
        System.out.println(firstNumbersList);

        BingoGame bingoGame = new BingoGame();
        System.out.println(bingoGame.playBingo(firstBoard, firstNumbersList));
        System.out.println(firstBoard);

    }
}
