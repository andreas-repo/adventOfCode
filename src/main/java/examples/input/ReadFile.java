package examples.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    private String filePath;

    public ReadFile() {}
    public ReadFile(String filePath) {
        this.filePath = filePath;
    }

    public List<String> readInputText() {
        List<String> inputList = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            return inputList;
        }

        try (BufferedReader input = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = input.readLine()) != null) {
                inputList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputList;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
