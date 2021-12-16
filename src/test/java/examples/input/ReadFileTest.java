package examples.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadFileTest {

    private ReadFile readFile;

    @BeforeEach
    public void init() {
        readFile = new ReadFile();
    }

    @Test
    void readInputText_whenFileDoesNotExist_thenCatchesExceptionAndReturnsEmptyList() {
        readFile.setFilePath("falseFile.txt");
        assertThat(readFile.readInputText())
                .isEqualTo(new ArrayList<>());
        assertThat(readFile.readInputText().isEmpty())
                .isTrue();
    }

    @Test
    void readInputText_whenFileExists_thenReturnsCorrectListSize() {
        readFile.setFilePath("C:\\Users\\andre\\Development\\Projekte\\adventOfCode\\inputtext.txt");
        assertThat(readFile.readInputText().size())
                .isEqualTo(2000);
    }
}
