package pl.kukla.krzys.jacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * @author Krzysztof Kukla
 */
@JsonTest
@ActiveProfiles("kebab")
public class BeerDtoKebabJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    private BeerDto beerDto;

    @BeforeEach
    void setUp() {
        beerDto = BeerDto.builder()
            .id(UUID.randomUUID())
            .beerName("aaa")
            .beerStyle("beer style eee")
            .upc(1111122L)
            .price(new BigDecimal("2.19"))
            .createdDate(OffsetDateTime.now())
            .lastUpdatedDate(OffsetDateTime.now())
            .build();
    }

    @Test
    void serialize() throws JsonProcessingException {
        String jsonString = objectMapper.writeValueAsString(beerDto);
        System.out.println(jsonString);
    }

    @Test
    void deserialize() throws Exception {
        String jsonString = "{\"id\":\"684b7694-4081-4a3f-9145-8405a84a065b\",\"beer-name\":\"aaa\",\"beer-style\":\"beer style eee\"," +
            "\"upc\":1111122,\"price\":2.19,\"created-date\":\"2020-02-05T12:43:14.7118758+01:00\",\"last-updated-date\":\"2020-02-05T12:43:14.712886+01:00\"}\n";

        BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);
        System.out.println(beerDto);
    }

}
