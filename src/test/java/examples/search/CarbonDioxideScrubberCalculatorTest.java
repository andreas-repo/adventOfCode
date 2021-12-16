package examples.search;

import examples.model.TwelveBits;
import examples.search.CarbonDioxideScrubberCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarbonDioxideScrubberCalculatorTest {

    CarbonDioxideScrubberCalculator carbonDioxideScrubberCalculator;

    @BeforeEach
    void init() {
        carbonDioxideScrubberCalculator = new CarbonDioxideScrubberCalculator();
    }

    @Test
    void calculate_whenCalculatesInput_thenReturnsCorrectElement() {
        //Expected result
        TwelveBits expected = new TwelveBits(false, false, false, false, true, false, true, true, true, false, false, true);

        TwelveBits result = carbonDioxideScrubberCalculator.calculate(generateTestList());
        assertThat(result.toString())
                .isEqualTo(expected.toString());
    }

    private List<TwelveBits> generateTestList() {
        TwelveBits bitsOne = new TwelveBits(true, false, true, false, true, false, true, true, true, false, false, true);
        TwelveBits bitsTwo = new TwelveBits(true, false, false, false, true, false, true, true, true, false, false, true);
        TwelveBits bitsThree = new TwelveBits(false, false, false, false, true, false, true, true, true, false, false, true);
        TwelveBits bitsFour = new TwelveBits(false, true, false, false, true, false, true, true, true, false, false, true);
        TwelveBits bitsFive = new TwelveBits(true, true, true, false, true, false, true, true, true, false, false, true);
        TwelveBits bitsSix = new TwelveBits(true, true, false, false, true, false, true, true, true, false, false, true);
        return List.of(bitsOne, bitsTwo, bitsThree, bitsFour, bitsFive, bitsSix);
    }
}
