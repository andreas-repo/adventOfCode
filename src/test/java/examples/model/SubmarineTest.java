package examples.model;

import examples.model.Submarine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SubmarineTest {

    private Submarine submarine;

    @BeforeEach
    public void init() {
        submarine = new Submarine();
    }

    @Test
    void countTimeOfDepthIncreases_whenUsingNullForArgument_thenReturnsZero() {
        assertEquals(0, submarine.countTimeOfDepthIncreases(null));
    }

    @Test
    void countTimeOfDepthIncreases_whenArgumentListIsEmpty_thenReturnsZero() {
        assertEquals(0, submarine.countTimeOfDepthIncreases(new ArrayList<>()));
    }

    @Test
    void countTimeOfDepthIncreases_whenArgumentListShouldReturnTwo_thenReturnsTwo() {
        assertEquals(2, submarine.countTimeOfDepthIncreases(returnTestInputListWithTwoRisingNumbers()));
    }

    @Test
    void countTimeOfDepthIncreases_whenArgumentListContainsNoRisingNumbers_thenReturnsZero() {
        assertEquals(0, submarine.countTimeOfDepthIncreases(returnTestInputListWithoutRisingNumbers()));
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
