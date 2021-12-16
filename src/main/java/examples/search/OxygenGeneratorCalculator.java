package examples.search;

import examples.model.TwelveBits;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OxygenGeneratorCalculator {

    private TwelveBits templateBits;
    private TwelveBits result;

    public TwelveBits calculate(List<TwelveBits> inputBits) {
        this.createTemplateBitObject(inputBits);

        List<TwelveBits> resultOne = inputBits.stream().filter(inputBit -> inputBit.isBitOne() == templateBits.isBitOne()).collect(Collectors.toList());
        if (resultOne.size() == 1) {
            return resultOne.get(0);
        }

        this.createTemplateBitObject(resultOne);

        List<TwelveBits> resultTwo = resultOne.stream().filter(inputBit -> inputBit.isBitTwo() == templateBits.isBitTwo()).collect(Collectors.toList());
        if (resultTwo.size() == 1) {
            return resultTwo.get(0);
        }

        this.createTemplateBitObject(resultTwo);

        List<TwelveBits> resultThree = resultTwo.stream().filter(inputBit -> inputBit.isBitThree() == templateBits.isBitThree()).collect(Collectors.toList());
        if (resultThree.size() == 1) {
            return resultThree.get(0);
        }

        this.createTemplateBitObject(resultThree);

        List<TwelveBits> resultFour = resultThree.stream().filter(inputBit -> inputBit.isBitFour() == templateBits.isBitFour()).collect(Collectors.toList());
        if (resultFour.size() == 1) {
            return resultFour.get(0);
        }

        this.createTemplateBitObject(resultFour);

        List<TwelveBits> resultFive = resultFour.stream().filter(inputBit -> inputBit.isBitFive() == templateBits.isBitFive()).collect(Collectors.toList());
        if (resultFive.size() == 1) {
            return resultFive.get(0);
        }

        this.createTemplateBitObject(resultFive);

        List<TwelveBits> resultSix = resultFive.stream().filter(inputBit -> inputBit.isBitSix() == templateBits.isBitSix()).collect(Collectors.toList());
        if (resultSix.size() == 1) {
            return resultSix.get(0);
        }

        this.createTemplateBitObject(resultSix);

        List<TwelveBits> resultSeven = resultSix.stream().filter(inputBit -> inputBit.isBitSeven() == templateBits.isBitSeven()).collect(Collectors.toList());
        if (resultSeven.size() == 1) {
            return resultSeven.get(0);
        }

        this.createTemplateBitObject(resultSeven);

        List<TwelveBits> resultEight = resultSeven.stream().filter(inputBit -> inputBit.isBitEight() == templateBits.isBitEight()).collect(Collectors.toList());
        if (resultEight.size() == 1) {
            return resultEight.get(0);
        }

        this.createTemplateBitObject(resultEight);

        List<TwelveBits> resultNine = resultEight.stream().filter(inputBit -> inputBit.isBitNine() == templateBits.isBitNine()).collect(Collectors.toList());
        if (resultNine.size() == 1) {
            return resultNine.get(0);
        }

        this.createTemplateBitObject(resultNine);

        List<TwelveBits> resultTen = resultNine.stream().filter(inputBit -> inputBit.isBitTen() == templateBits.isBitTen()).collect(Collectors.toList());
        if (resultTen.size() == 1) {
            return resultTen.get(0);
        }

        this.createTemplateBitObject(resultTen);

        List<TwelveBits> resultEleven = resultTen.stream().filter(inputBit -> inputBit.isBitEleven() == templateBits.isBitEleven()).collect(Collectors.toList());
        if (resultEleven.size() == 1) {
            return resultEleven.get(0);
        }

        this.createTemplateBitObject(resultEleven);

        List<TwelveBits> resultTwelve = resultEleven.stream().filter(inputBit -> inputBit.isBitTwelve() == templateBits.isBitTwelve()).collect(Collectors.toList());
        if (resultTwelve.size() == 1) {
            return resultTwelve.get(0);
        }

        return new TwelveBits();
    }

    private AtomicBoolean checkIfElementsAreEqual(List<TwelveBits> list) {
        if (list.isEmpty()) {
            return new AtomicBoolean(false);
        }

        AtomicBoolean result = new AtomicBoolean(true);
        TwelveBits compareTo = list.get(0);

        list.forEach(element -> {
            if (!element.equals(compareTo)) {
                result.set(false);
            }
        });
        return result;
    }

    private List<AtomicInteger> getListOfOnes(List<TwelveBits> inputBitsList) {
        //amount of ones
        List<AtomicInteger> listOfOneAmounts = getAtomicIntegerList();

        inputBitsList.forEach(tempBits -> {
            if (tempBits.isBitOne()) {
                listOfOneAmounts.get(0).getAndIncrement();
            }
            if (tempBits.isBitTwo()) {
                listOfOneAmounts.get(1).getAndIncrement();
            }
            if (tempBits.isBitThree()) {
                listOfOneAmounts.get(2).getAndIncrement();
            }
            if (tempBits.isBitFour()) {
                listOfOneAmounts.get(3).getAndIncrement();
            }
            if (tempBits.isBitFive()) {
                listOfOneAmounts.get(4).getAndIncrement();
            }
            if (tempBits.isBitSix()) {
                listOfOneAmounts.get(5).getAndIncrement();
            }
            if (tempBits.isBitSeven()) {
                listOfOneAmounts.get(6).getAndIncrement();
            }
            if (tempBits.isBitEight()) {
                listOfOneAmounts.get(7).getAndIncrement();
            }
            if (tempBits.isBitNine()) {
                listOfOneAmounts.get(8).getAndIncrement();
            }
            if (tempBits.isBitTen()) {
                listOfOneAmounts.get(9).getAndIncrement();
            }
            if (tempBits.isBitEleven()) {
                listOfOneAmounts.get(10).getAndIncrement();
            }
            if (tempBits.isBitTwelve()) {
                listOfOneAmounts.get(11).getAndIncrement();
            }
        });

        return listOfOneAmounts;
    }

    private List<AtomicInteger> getListOfZeros(List<TwelveBits> inputBitsList) {
        //amount of zeros
        List<AtomicInteger> listOfZeroAmounts = getAtomicIntegerList();

        inputBitsList.forEach(tempBits -> {
            if (!tempBits.isBitOne()) {
                listOfZeroAmounts.get(0).getAndIncrement();
            }
            if (!tempBits.isBitTwo()) {
                listOfZeroAmounts.get(1).getAndIncrement();
            }
            if (!tempBits.isBitThree()) {
                listOfZeroAmounts.get(2).getAndIncrement();
            }
            if (!tempBits.isBitFour()) {
                listOfZeroAmounts.get(3).getAndIncrement();
            }
            if (!tempBits.isBitFive()) {
                listOfZeroAmounts.get(4).getAndIncrement();
            }
            if (!tempBits.isBitSix()) {
                listOfZeroAmounts.get(5).getAndIncrement();
            }
            if (!tempBits.isBitSeven()) {
                listOfZeroAmounts.get(6).getAndIncrement();
            }
            if (!tempBits.isBitEight()) {
                listOfZeroAmounts.get(7).getAndIncrement();
            }
            if (!tempBits.isBitNine()) {
                listOfZeroAmounts.get(8).getAndIncrement();
            }
            if (!tempBits.isBitTen()) {
                listOfZeroAmounts.get(9).getAndIncrement();
            }
            if (!tempBits.isBitEleven()) {
                listOfZeroAmounts.get(10).getAndIncrement();
            }
            if (!tempBits.isBitTwelve()) {
                listOfZeroAmounts.get(11).getAndIncrement();
            }
        });

        return listOfZeroAmounts;
    }

    private List<AtomicInteger> getAtomicIntegerList() {
        AtomicInteger amountOne = new AtomicInteger();
        AtomicInteger amountTwo = new AtomicInteger();
        AtomicInteger amountThree = new AtomicInteger();
        AtomicInteger amountFour = new AtomicInteger();
        AtomicInteger amountFive = new AtomicInteger();
        AtomicInteger amountSix = new AtomicInteger();
        AtomicInteger amountSeven = new AtomicInteger();
        AtomicInteger amountEight = new AtomicInteger();
        AtomicInteger amountNine = new AtomicInteger();
        AtomicInteger amountTen = new AtomicInteger();
        AtomicInteger amountEleven = new AtomicInteger();
        AtomicInteger amountTwelve = new AtomicInteger();

        return List.of(amountOne, amountTwo, amountThree, amountFour, amountFive, amountSix, amountSeven, amountEight, amountNine, amountTen, amountEleven, amountTwelve);
    }

    private void createTemplateBitObject(List<TwelveBits> inputBitsList) {
        List<AtomicInteger> listOfZeroAmounts = this.getListOfZeros(inputBitsList);
        List<AtomicInteger> listOfOneAmounts = this.getListOfOnes(inputBitsList);

        Boolean[] template = new Boolean[12];

        for (int i = 0; i < listOfZeroAmounts.size(); i++) {
            if (listOfZeroAmounts.get(i).get() == listOfOneAmounts.get(i).get()) {
                template[i] = true;
            } else if (listOfZeroAmounts.get(i).get() > listOfOneAmounts.get(i).get()) {
                template[i] = false;
            } else {
                template[i] = true;
            }
        }
        templateBits = new TwelveBits(template[0], template[1], template[2], template[3], template[4], template[5], template[6], template[7], template[8], template[9], template[10], template[11]);

    }
}
