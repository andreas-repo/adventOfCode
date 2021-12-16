package examples.model;

import examples.helper.FormatInput;
import examples.search.CarbonDioxideScrubberCalculator;
import examples.search.OxygenGeneratorCalculator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import javax.inject.Inject;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static examples.helper.BinaryConverter.convertToDecimal;

public class Submarine {

    private long horizontalPosition;
    private long depth;
    private long aim;
    private TwelveBits gammaRate;
    private TwelveBits epsilonRate;
    private TwelveBits oxygenGeneratorRating;
    private TwelveBits carbonDioxideScrubberRating;
    private long consumptionRate;

    private OxygenGeneratorCalculator oxygenGeneratorCalculator = new OxygenGeneratorCalculator();
    private CarbonDioxideScrubberCalculator carbonDioxideScrubberCalculator = new CarbonDioxideScrubberCalculator();

    public void calculateOxygenGeneratorRating(List<TwelveBits> inputBits) {
        this.oxygenGeneratorRating = this.oxygenGeneratorCalculator.calculate(inputBits);
    }

    public void calculateCarbonDioxideScrubberRating(List<TwelveBits> inputBits) {
        this.carbonDioxideScrubberRating = this.carbonDioxideScrubberCalculator.calculate(inputBits);
    }

    public void calculatePowerConsumption(List<TwelveBits> inputList) {
        calculateEpsilonRateInBits(inputList);
        calculateGammaRateInBits(inputList);

        long decimalGammaValue = convertToDecimal(this.gammaRate);
        long decimalEpsilonValue = convertToDecimal(this.epsilonRate);

        this.consumptionRate = decimalGammaValue * decimalEpsilonValue;
    }

    private @Unmodifiable List<AtomicInteger> getAtomicIntegerList() {
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
    //TODO move into separate class
    private void calculateEpsilonRateInBits(@NotNull List<TwelveBits> inputList) {
        //amount of zeros
        List<AtomicInteger> listOfZeroAmounts = getAtomicIntegerList();
        //amount of ones
        List<AtomicInteger> listOfOneAmounts = getAtomicIntegerList();

        inputList.forEach(tempBits -> {
            if (!tempBits.isBitOne()) {
                listOfZeroAmounts.get(0).getAndIncrement();
            } else {
                listOfOneAmounts.get(0).getAndIncrement();
            }
            if (!tempBits.isBitTwo()) {
                listOfZeroAmounts.get(1).getAndIncrement();
            }
            else {
                listOfOneAmounts.get(1).getAndIncrement();
            }
            if (!tempBits.isBitThree()) {
                listOfZeroAmounts.get(2).getAndIncrement();
            } else {
                listOfOneAmounts.get(2).getAndIncrement();
            }
            if (!tempBits.isBitFour()) {
                listOfZeroAmounts.get(3).getAndIncrement();
            } else {
                listOfOneAmounts.get(3).getAndIncrement();
            }
            if (!tempBits.isBitFive()) {
                listOfZeroAmounts.get(4).getAndIncrement();
            } else {
                listOfOneAmounts.get(4).getAndIncrement();
            }
            if (!tempBits.isBitSix()) {
                listOfZeroAmounts.get(5).getAndIncrement();
            } else {
                listOfOneAmounts.get(5).getAndIncrement();
            }
            if (!tempBits.isBitSeven()) {
                listOfZeroAmounts.get(6).getAndIncrement();
            } else {
                listOfOneAmounts.get(6).getAndIncrement();
            }
            if (!tempBits.isBitEight()) {
                listOfZeroAmounts.get(7).getAndIncrement();
            } else {
                listOfOneAmounts.get(7).getAndIncrement();
            }
            if (!tempBits.isBitNine()) {
                listOfZeroAmounts.get(8).getAndIncrement();
            } else {
                listOfOneAmounts.get(8).getAndIncrement();
            }
            if (!tempBits.isBitTen()) {
                listOfZeroAmounts.get(9).getAndIncrement();
            } else {
                listOfOneAmounts.get(9).getAndIncrement();
            }
            if (!tempBits.isBitEleven()) {
                listOfZeroAmounts.get(10).getAndIncrement();
            } else {
                listOfOneAmounts.get(10).getAndIncrement();
            }
            if (!tempBits.isBitTwelve()) {
                listOfZeroAmounts.get(11).getAndIncrement();
            } else {
                listOfOneAmounts.get(11).getAndIncrement();
            }
        });

        this.epsilonRate = new TwelveBits(this.isLeastCommonBit(listOfZeroAmounts.get(0), listOfOneAmounts.get(0)), this.isLeastCommonBit(listOfZeroAmounts.get(1), listOfOneAmounts.get(1)),
                this.isLeastCommonBit(listOfZeroAmounts.get(2), listOfOneAmounts.get(2)), this.isLeastCommonBit(listOfZeroAmounts.get(3), listOfOneAmounts.get(3)),
                this.isLeastCommonBit(listOfZeroAmounts.get(4), listOfOneAmounts.get(4)), this.isLeastCommonBit(listOfZeroAmounts.get(5), listOfOneAmounts.get(5)),
                this.isLeastCommonBit(listOfZeroAmounts.get(6), listOfOneAmounts.get(6)), this.isLeastCommonBit(listOfZeroAmounts.get(7), listOfOneAmounts.get(7)),
                this.isLeastCommonBit(listOfZeroAmounts.get(8), listOfOneAmounts.get(8)), this.isLeastCommonBit(listOfZeroAmounts.get(9), listOfOneAmounts.get(9)),
                this.isLeastCommonBit(listOfZeroAmounts.get(10), listOfOneAmounts.get(10)), this.isLeastCommonBit(listOfZeroAmounts.get(11), listOfOneAmounts.get(11)));
    }
    //TODO move into separate class
    private void calculateGammaRateInBits(@NotNull List<TwelveBits> inputList) {
        //amount of zeros
        List<AtomicInteger> listOfZeroAmounts = getAtomicIntegerList();
        //amount of ones
        List<AtomicInteger> listOfOneAmounts = getAtomicIntegerList();

        inputList.forEach(tempBits -> {
            if (!tempBits.isBitOne()) {
                listOfZeroAmounts.get(0).getAndIncrement();
            } else {
                listOfOneAmounts.get(0).getAndIncrement();
            }
            if (!tempBits.isBitTwo()) {
                listOfZeroAmounts.get(1).getAndIncrement();
            }
            else {
                listOfOneAmounts.get(1).getAndIncrement();
            }
            if (!tempBits.isBitThree()) {
                listOfZeroAmounts.get(2).getAndIncrement();
            } else {
                listOfOneAmounts.get(2).getAndIncrement();
            }
            if (!tempBits.isBitFour()) {
                listOfZeroAmounts.get(3).getAndIncrement();
            } else {
                listOfOneAmounts.get(3).getAndIncrement();
            }
            if (!tempBits.isBitFive()) {
                listOfZeroAmounts.get(4).getAndIncrement();
            } else {
                listOfOneAmounts.get(4).getAndIncrement();
            }
            if (!tempBits.isBitSix()) {
                listOfZeroAmounts.get(5).getAndIncrement();
            } else {
                listOfOneAmounts.get(5).getAndIncrement();
            }
            if (!tempBits.isBitSeven()) {
                listOfZeroAmounts.get(6).getAndIncrement();
            } else {
                listOfOneAmounts.get(6).getAndIncrement();
            }
            if (!tempBits.isBitEight()) {
                listOfZeroAmounts.get(7).getAndIncrement();
            } else {
                listOfOneAmounts.get(7).getAndIncrement();
            }
            if (!tempBits.isBitNine()) {
                listOfZeroAmounts.get(8).getAndIncrement();
            } else {
                listOfOneAmounts.get(8).getAndIncrement();
            }
            if (!tempBits.isBitTen()) {
                listOfZeroAmounts.get(9).getAndIncrement();
            } else {
                listOfOneAmounts.get(9).getAndIncrement();
            }
            if (!tempBits.isBitEleven()) {
                listOfZeroAmounts.get(10).getAndIncrement();
            } else {
                listOfOneAmounts.get(10).getAndIncrement();
            }
            if (!tempBits.isBitTwelve()) {
                listOfZeroAmounts.get(11).getAndIncrement();
            } else {
                listOfOneAmounts.get(11).getAndIncrement();
            }
        });

        this.gammaRate = new TwelveBits(this.isMostCommonBit(listOfZeroAmounts.get(0), listOfOneAmounts.get(0)), this.isMostCommonBit(listOfZeroAmounts.get(1), listOfOneAmounts.get(1)),
                this.isMostCommonBit(listOfZeroAmounts.get(2), listOfOneAmounts.get(2)), this.isMostCommonBit(listOfZeroAmounts.get(3), listOfOneAmounts.get(3)),
                this.isMostCommonBit(listOfZeroAmounts.get(4), listOfOneAmounts.get(4)), this.isMostCommonBit(listOfZeroAmounts.get(5), listOfOneAmounts.get(5)),
                this.isMostCommonBit(listOfZeroAmounts.get(6), listOfOneAmounts.get(6)), this.isMostCommonBit(listOfZeroAmounts.get(7), listOfOneAmounts.get(7)),
                this.isMostCommonBit(listOfZeroAmounts.get(8), listOfOneAmounts.get(8)), this.isMostCommonBit(listOfZeroAmounts.get(9), listOfOneAmounts.get(9)),
                this.isMostCommonBit(listOfZeroAmounts.get(10), listOfOneAmounts.get(10)), this.isMostCommonBit(listOfZeroAmounts.get(11), listOfOneAmounts.get(11)));
    }

    private boolean isMostCommonBit(@NotNull AtomicInteger amountOfZeros, @NotNull AtomicInteger amountOfOnes) {
        if (amountOfZeros.get() > amountOfOnes.get()) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isLeastCommonBit(@NotNull AtomicInteger amountOfZeros, @NotNull AtomicInteger amountOfOnes) {
        if (amountOfZeros.get() > amountOfOnes.get()) {
            return true;
        } else {
            return false;
        }
    }

    public void followCourse(List<String> inputList) {
        List<Command> commandList = FormatInput.toCommandList(inputList);

        commandList.forEach(command -> {
            switch(command.getCommand().toLowerCase()) {
                case "forward":
                    break;
                case "backward":
                    moveBackward(command.getAmount());
                    break;
                case "down":
                    moveDown(command.getAmount());
                    break;
                case "up":
                    moveUp(command.getAmount());
                    break;
            }
        });
    }

    public void moveForward(long amount) {
        horizontalPosition = horizontalPosition + amount;
        depth = depth + (aim * amount);
    }

    public void moveBackward(long amount) {
        horizontalPosition = horizontalPosition - amount;
    }

    public void moveDown(long amount) {
        aim = aim + amount;
    }

    public void moveUp(long amount) {
        aim = aim - amount;
    }

    public int countTimeOfDepthIncreases(@NotEmpty List<String> inputList) {
        if (inputList == null) {
            return 0;
        }

        AtomicInteger counter = new AtomicInteger();

        Optional<String> result = inputList.stream().reduce((a, b) -> {
            int previous = Integer.parseInt(a);
            int next = Integer.parseInt(b);

            if (previous < next) {
                counter.getAndIncrement();
            }

            return b;
        });

        return Integer.parseInt(counter.toString());
    }

    public List<String> createValuesOfSlidingWindow(@NotEmpty @NotNull List<String> inputList) {
        List<String> createdValueForComparing = new ArrayList<>();

        if (inputList.size() == 1) {
            return new ArrayList<>();
        }

        for (int i = 0; i < inputList.size() - 2; i++) {
            int valueOne = Integer.parseInt(inputList.get(i));
            int valueTwo = Integer.parseInt(inputList.get(i + 1));
            int valueThree = Integer.parseInt(inputList.get(i + 2));
            int sum = valueOne + valueTwo + valueThree;
            createdValueForComparing.add(String.valueOf(sum));
        }

       return createdValueForComparing;
    }

    public long multiplyHorizontalWithDepth() {
        return horizontalPosition * depth;
    }

    public long getHorizontalPosition() {
        return horizontalPosition;
    }

    public void setHorizontalPosition(long horizontalPosition) {
        this.horizontalPosition = horizontalPosition;
    }

    public long getDepth() {
        return depth;
    }

    public void setDepth(long depth) {
        this.depth = depth;
    }

    public long getAim() {
        return aim;
    }

    public void setAim(long aim) {
        this.aim = aim;
    }

    public TwelveBits getGammaRate() {
        return gammaRate;
    }

    public void setGammaRate(TwelveBits gammaRate) {
        this.gammaRate = gammaRate;
    }

    public TwelveBits getEpsilonRate() {
        return epsilonRate;
    }

    public void setEpsilonRate(TwelveBits epsilonRate) {
        this.epsilonRate = epsilonRate;
    }

    public long getConsumptionRate() {
        return consumptionRate;
    }

    public void setConsumptionRate(long consumptionRate) {
        this.consumptionRate = consumptionRate;
    }

    public TwelveBits getOxygenGeneratorRating() {
        return oxygenGeneratorRating;
    }

    public void setOxygenGeneratorRating(TwelveBits oxygenGeneratorRating) {
        this.oxygenGeneratorRating = oxygenGeneratorRating;
    }

    public TwelveBits getCarbonDioxideScrubberRating() {
        return carbonDioxideScrubberRating;
    }

    public void setCarbonDioxideScrubberRating(TwelveBits carbonDioxideScrubberRating) {
        this.carbonDioxideScrubberRating = carbonDioxideScrubberRating;
    }

    public OxygenGeneratorCalculator getOxygenGeneratorCalculator() {
        return oxygenGeneratorCalculator;
    }

    public void setOxygenGeneratorCalculator(OxygenGeneratorCalculator oxygenGeneratorCalculator) {
        this.oxygenGeneratorCalculator = oxygenGeneratorCalculator;
    }

    public CarbonDioxideScrubberCalculator getCarbonDioxideScrubberCalculator() {
        return carbonDioxideScrubberCalculator;
    }

    public void setCarbonDioxideScrubberCalculator(CarbonDioxideScrubberCalculator carbonDioxideScrubberCalculator) {
        this.carbonDioxideScrubberCalculator = carbonDioxideScrubberCalculator;
    }
}
