package examples.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReadFileTest {

    private ReadFile readFile;

    @BeforeEach
    public void init() {
        readFile = new ReadFile();
    }

    @Test
    void readInputText_whenFileDoesNotExist_thenCatchesExceptionAndReturnsEmptyList() {
        readFile.setFilePath("falseFile.txt");
        assertEquals(new ArrayList<>(), readFile.readInputText());
        assertTrue(readFile.readInputText().isEmpty());
    }

    @Test
    void readInputText_whenFileExists_thenReturnsCorrectListSize() {
        readFile.setFilePath("C:\\Users\\andre\\Development\\Projekte\\adventOfCode\\inputtext.txt");
        assertEquals(2000, readFile.readInputText().size());
    }
}
