package fasttrack.ro;

import lombok.Builder;

import java.util.List;
@Builder
public record Country(
        Integer id,
        String name,
        String capital,
        Long population,
        Long area,
        Continents continent,
        List<String> neighbours
) {
}
