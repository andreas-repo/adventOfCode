package examples.helper;

import examples.model.BingoBoard;
import examples.model.BingoNumber;
import examples.model.Command;
import examples.model.TwelveBits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormatInput {

    public static List<List<Integer>> getAllBoardsWithNumbers(List<String> inputList) {
        List<List<Integer>> bingoBoardList = new ArrayList<>();
        List<Integer> tempBingoNumbers = new ArrayList<>();

        inputList.forEach(line -> {
            if(line.equals("")) {
                bingoBoardList.add(tempBingoNumbers);
                tempBingoNumbers.clear();
            } else {
                List<String> tempStringList =  Arrays.asList(line.split(" "));
                List<Integer> tempIntegerList = new ArrayList<>();
                tempStringList.forEach(tempString -> {
                    if(!tempString.equals("")) {
                        tempIntegerList.add(Integer.valueOf(tempString));
                    }
                });
                tempBingoNumbers.addAll(tempIntegerList);
            }
        });

        return bingoBoardList;
    }

    public static List<BingoBoard> getAllPlacesOnBoard(List<List<Integer>> boardList) {
        List<BingoBoard> bingoBoardList = new ArrayList<>();


        boardList.forEach(board -> {
            BingoBoard bingoBoard = new BingoBoard();
            List<BingoNumber> tempBingoNumbers = new ArrayList<>();
            for (int i = 0; i < board.size(); i++) {
                BingoNumber bingoNumber = new BingoNumber();
                bingoNumber.setNumber(boardList.get(0).get(i));
                bingoNumber.setPlaceOnBoard(i);
                tempBingoNumbers.add(bingoNumber);
            }
            bingoBoard.setBoard(tempBingoNumbers);
            bingoBoardList.add(bingoBoard);
        });

        return bingoBoardList;
    }

    public static List<Integer> toBingoInputList(List<String> inputList) {
        List<Integer> inputBingoNumbers = new ArrayList<>();
        inputList.forEach(inputLine -> {
            List<String> tempStringList =  Arrays.asList(inputLine.split(","));
            List<Integer> tempIntegerList = new ArrayList<>();
            tempStringList.forEach(tempString -> {
                tempIntegerList.add(Integer.valueOf(tempString));
            });
            inputBingoNumbers.addAll(tempIntegerList);
        });

        return inputBingoNumbers;
    }

    public static List<Command> toCommandList(List<String> inputList) {
        List<Command> commandList = new ArrayList<>();
        inputList.forEach(inputString -> {
            Command command = new Command();
            String[] split = inputString.split(" ");
            command.setCommand(split[0].trim());
            command.setAmount(Long.parseLong(split[1]));
            commandList.add(command);
        });

        return commandList;
    }

    public static List<TwelveBits> toTwelveBit(List<String> inputList) {
        List<TwelveBits> bitList = new ArrayList<>();
        inputList.forEach(bitString -> {
            TwelveBits twelveBits = new TwelveBits();
            String[] splitResult = bitString.split("");

            twelveBits.setBitOne(convertNumbersToBooleanValues(splitResult[0]));
            twelveBits.setBitTwo(convertNumbersToBooleanValues(splitResult[1]));
            twelveBits.setBitThree(convertNumbersToBooleanValues(splitResult[2]));
            twelveBits.setBitFour(convertNumbersToBooleanValues(splitResult[3]));
            twelveBits.setBitFive(convertNumbersToBooleanValues(splitResult[4]));
            twelveBits.setBitSix(convertNumbersToBooleanValues(splitResult[5]));
            twelveBits.setBitSeven(convertNumbersToBooleanValues(splitResult[6]));
            twelveBits.setBitEight(convertNumbersToBooleanValues(splitResult[7]));
            twelveBits.setBitNine(convertNumbersToBooleanValues(splitResult[8]));
            twelveBits.setBitTen(convertNumbersToBooleanValues(splitResult[9]));
            twelveBits.setBitEleven(convertNumbersToBooleanValues(splitResult[10]));
            twelveBits.setBitTwelve(convertNumbersToBooleanValues(splitResult[11]));

            bitList.add(twelveBits);
        });

        return bitList;
    }

    private static boolean convertNumbersToBooleanValues(String value) {
        if (value.equals("0")) {
            return false;
        } else {
            return true;
        }
    }
}
