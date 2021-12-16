package examples.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SubmarineTest {

    private Submarine submarine;

    @BeforeEach
    public void init() {
        submarine = new Submarine();
    }

    @Test
    void countTimeOfDepthIncreases_whenUsingNullForArgument_thenReturnsZero() {
        assertThat(submarine.countTimeOfDepthIncreases(null))
                .isEqualTo(0);
    }

    @Test
    void countTimeOfDepthIncreases_whenArgumentListIsEmpty_thenReturnsZero() {
        assertThat(submarine.countTimeOfDepthIncreases(new ArrayList<>()))
                .isEqualTo(0);
    }

    @Test
    void countTimeOfDepthIncreases_whenArgumentListShouldReturnTwo_thenReturnsTwo() {
        assertThat(submarine.countTimeOfDepthIncreases(returnTestInputListWithTwoRisingNumbers()))
                .isEqualTo(2);
    }

    @Test
    void countTimeOfDepthIncreases_whenArgumentListContainsNoRisingNumbers_thenReturnsZero() {
        assertThat(submarine.countTimeOfDepthIncreases(returnTestInputListWithoutRisingNumbers()))
                .isEqualTo(0);
    }

    private List<String> returnTestInputListWithTwoRisingNumbers() {
        String[] data = {"1", "2", "2", "4", "4"};
        return Arrays.asList(data);
    }

    private List<String> returnTestInputListWithoutRisingNumbers() {
        String[] data = {"1", "1", "1", "1", "1"};
        return Arrays.asList(data);
    }

}
