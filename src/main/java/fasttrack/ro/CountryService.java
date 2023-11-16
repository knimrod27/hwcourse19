package fasttrack.ro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CountryService {
    List<Country> countries;

    public CountryService(List<Country> countries) {
        this.countries = Optional.ofNullable(countries)
                .orElseGet(ArrayList:: new);
    }
    public List<Country> listAllCountries() {
        return countries;
    }


    public List<String> listAllCountryNames() {
        return countries.stream()
                .map(Country::name)
                .toList();
    }
    public String getCapitalByCountry(String countryName) {
        return countries.stream().
                filter(country -> country.name().equalsIgnoreCase(countryName))
                .findFirst()
                .map(Country::capital)
                .orElse("No country like this");

    }

    public Long getPopulationOfACountry(String countryName) {
        return countries.stream().
                filter(country -> country.name().equalsIgnoreCase(countryName))
                .findFirst()
                .map(Country::population)
                .orElse(-1l);
    }

    public List<Country> getCountriesByContinent(String continents) {
        return countries.stream()
                .filter(country -> country.continent().equals(Continents.of(continents)))
                .toList();
    }

    public List<String> getNeighbourByCountry(String country) {
        return countries.stream()
                .filter(country1 -> country1.name().equalsIgnoreCase(country))
                .map(Country::neighbours)
                .findAny()
                .orElseThrow();
    }

    //Couldn't do the last 2 methods
}



