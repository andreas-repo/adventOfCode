package examples.model;

public class TwelveBits {

    private boolean bitOne;
    private boolean bitTwo;
    private boolean bitThree;
    private boolean bitFour;
    private boolean bitFive;
    private boolean bitSix;
    private boolean bitSeven;
    private boolean bitEight;
    private boolean bitNine;
    private boolean bitTen;
    private boolean bitEleven;
    private boolean bitTwelve;

    public TwelveBits() {}
    public TwelveBits(boolean bitOne, boolean bitTwo, boolean bitThree, boolean bitFour, boolean bitFive, boolean bitSix, boolean bitSeven, boolean bitEight, boolean bitNine, boolean bitTen, boolean bitEleven, boolean bitTwelve) {
        this.bitOne = bitOne;
        this.bitTwo = bitTwo;
        this.bitThree = bitThree;
        this.bitFour = bitFour;
        this.bitFive = bitFive;
        this.bitSix = bitSix;
        this.bitSeven = bitSeven;
        this.bitEight = bitEight;
        this.bitNine = bitNine;
        this.bitTen = bitTen;
        this.bitEleven = bitEleven;
        this.bitTwelve = bitTwelve;
    }

    public boolean isBitOne() {
        return bitOne;
    }

    public void setBitOne(boolean bitOne) {
        this.bitOne = bitOne;
    }

    public boolean isBitTwo() {
        return bitTwo;
    }

    public void setBitTwo(boolean bitTwo) {
        this.bitTwo = bitTwo;
    }

    public boolean isBitThree() {
        return bitThree;
    }

    public void setBitThree(boolean bitThree) {
        this.bitThree = bitThree;
    }

    public boolean isBitFour() {
        return bitFour;
    }

    public void setBitFour(boolean bitFour) {
        this.bitFour = bitFour;
    }

    public boolean isBitFive() {
        return bitFive;
    }

    public void setBitFive(boolean bitFive) {
        this.bitFive = bitFive;
    }

    public boolean isBitSix() {
        return bitSix;
    }

    public void setBitSix(boolean bitSix) {
        this.bitSix = bitSix;
    }

    public boolean isBitSeven() {
        return bitSeven;
    }

    public void setBitSeven(boolean bitSeven) {
        this.bitSeven = bitSeven;
    }

    public boolean isBitEight() {
        return bitEight;
    }

    public void setBitEight(boolean bitEight) {
        this.bitEight = bitEight;
    }

    public boolean isBitNine() {
        return bitNine;
    }

    public void setBitNine(boolean bitNine) {
        this.bitNine = bitNine;
    }

    public boolean isBitTen() {
        return bitTen;
    }

    public void setBitTen(boolean bitTen) {
        this.bitTen = bitTen;
    }

    public boolean isBitEleven() {
        return bitEleven;
    }

    public void setBitEleven(boolean bitEleven) {
        this.bitEleven = bitEleven;
    }

    public boolean isBitTwelve() {
        return bitTwelve;
    }

    public void setBitTwelve(boolean bitTwelve) {
        this.bitTwelve = bitTwelve;
    }

    @Override
    public String toString() {
        return "TwelveBit{" +
                "bitOne=" + bitOne +
                ", bitTwo=" + bitTwo +
                ", bitThree=" + bitThree +
                ", bitFour=" + bitFour +
                ", bitFive=" + bitFive +
                ", bitSix=" + bitSix +
                ", bitSeven=" + bitSeven +
                ", bitEight=" + bitEight +
                ", bitNine=" + bitNine +
                ", bitTen=" + bitTen +
                ", bitEleven=" + bitEleven +
                ", bitTwelve=" + bitTwelve +
                '}';
    }
}
