package examples;

import examples.helper.FormatInput;
import examples.input.ReadFile;
import examples.model.BingoBoard;
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
        List<Integer> inputBingoNumbers = FormatInput.toBingoInputList(inputStringBingoNumbers);
        System.out.println(inputBingoNumbers);

        readFile.setFilePath("C:\\Users\\andre\\Development\\Projekte\\adventOfCode\\bingoBoards.txt");
        List<String> inputStringBingoBoards = readFile.readInputText();
        List<BingoBoard> inputBingoBoards = FormatInput.toBingoBoard(inputStringBingoBoards);
        System.out.println(inputBingoBoards);
        System.out.println(inputBingoBoards.size());
    }
}
