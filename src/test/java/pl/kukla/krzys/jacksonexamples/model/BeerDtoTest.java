package pl.kukla.krzys.jacksonexamples.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

/**
 * @author Krzysztof Kukla
 */
//in SpringBoot @JsonTest annotation allows to bring up slice context of Spring - only for Json environment
//in Spring Boot by default it is Jackson - we can change it in configuration
@JsonTest
class BeerDtoTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void serializeDtoToStringValue() throws Exception {
        BeerDto beerDto = getBeerDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void deserializeStringToDtoObject() throws Exception {
        String string = "{\"id\":\"10ace37c-bb42-49e8-9a55-20a550848c65\",\"beerName\":\"aaa\",\"beerStyle\":\"beer style eee\",\"upc\":1111122," +
            "\"price\":2.19,\"createdDate\":\"2020-02-04T21:56:44.1618956+01:00\",\"lastUpdatedDate\":\"2020-02-04T21:56:44.1629156+01:00\"}\n";

        BeerDto beerDto = objectMapper.readValue(string, BeerDto.class);

        System.out.println(beerDto);

    }

}