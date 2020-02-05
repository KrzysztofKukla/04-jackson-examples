package pl.kukla.krzys.jacksonexamples.model;

import org.junit.jupiter.api.Test;

/**
 * @author Krzysztof Kukla
 */
class BeerDtoJsonTest extends BaseJsonTest {

    @Test
    void serializeDtoToStringValue() throws Exception {
        BeerDto beerDto = getBeerDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void deserializeStringToDtoObject() throws Exception {
        String stringValue = "{\"beerName\":\"aaa\",\"beerStyle\":\"beer style eee\",\"upc\":1111122,\"price\":\"2.19\"," +
            "\"createdDate\":\"2020-02-05T21:10:29+0100\",\"lastUpdatedDate\":\"2020-02-05T21:10:29.1538793+01:00\",\"myLocalDate\":\"20200205\",\"beerId\":\"3d088dff-f595-4730-a7ff-28209896a145\"}\n";

        BeerDto beerDto = objectMapper.readValue(stringValue, BeerDto.class);

        System.out.println(beerDto);

    }

}