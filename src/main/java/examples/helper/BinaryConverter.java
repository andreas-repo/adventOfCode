package examples.helper;

import examples.model.TwelveBits;

public class BinaryConverter {

    public static int convertToDecimal(TwelveBits twelveBits) {
        String bitsString = booleanToBinaryValue(twelveBits.isBitOne()) + booleanToBinaryValue(twelveBits.isBitTwo()) + booleanToBinaryValue(twelveBits.isBitThree()) + booleanToBinaryValue(twelveBits.isBitFour())
                + booleanToBinaryValue(twelveBits.isBitFive()) + booleanToBinaryValue(twelveBits.isBitSix()) + booleanToBinaryValue(twelveBits.isBitSeven()) + booleanToBinaryValue(twelveBits.isBitEight())
                + booleanToBinaryValue(twelveBits.isBitNine()) + booleanToBinaryValue(twelveBits.isBitTen()) + booleanToBinaryValue(twelveBits.isBitEleven()) + booleanToBinaryValue(twelveBits.isBitTwelve());


        int decimalNumber = 0, i = 0;
        long remainder;
        long binaryNumber = Long.parseLong(bitsString);

        while (binaryNumber != 0) {
            remainder = binaryNumber % 10;
            binaryNumber /= 10;
            decimalNumber += remainder * Math.pow(2, i);
            ++i;
        }

        return decimalNumber;
    }

    private static String booleanToBinaryValue(boolean value) {
        if (value) {
            return "1";
        } else {
            return "0";
        }
    }
}
