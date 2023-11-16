package fasttrack.ro;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CountryReader reader = new CountryReader("src/main/resources/countries (1).txt");
        //reader.readLines().forEach(System.out::println);
         CountryService service = new CountryService(reader.readLines());
        service.listAllCountries().forEach(System.out::println);
        System.out.println(service.getCapitalByCountry("Romania"));
        System.out.println(service.getPopulationOfACountry("romania"));
        System.out.println(service.getNeighbourByCountry("romania"));
        System.out.println("==========================");
        // service.getCountriesByContinent(Continents.of("Africa")).forEach(System.out::println);
        service.getCountriesByContinent("africa").forEach(System.out::println);



    }
}