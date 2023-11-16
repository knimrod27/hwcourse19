package fasttrack.ro;

import lombok.Builder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountryReader {
    public static int ID = 1;
    private final String inputFile;

    public CountryReader(String inputFile) {
        this.inputFile = inputFile;

    }

    public List<Country> readLines() {
        List<Country> countries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))){
            return reader.lines().map(this:: parseCountry).toList();




        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Country parseCountry(String line) {
        String[] tokens = line.split("[|]");
        return Country.builder()
                .id(ID++)
                .name(tokens[0])
                .capital(tokens[1])
                .population(Long.parseLong(tokens[2]))
                .area(Long.parseLong(tokens[3]))
                .continent(Continents.of(tokens[4]))
                .neighbours(tokens.length == 6? neighbourList(tokens[5]) : List.of())
                .build();
    }

    private List<String> neighbourList(String neighboursString) {
        String[] tokens = neighboursString.split("~");
        return Arrays.asList(tokens);
    }

    public String getInputFile() {
        return inputFile;
    }

}
