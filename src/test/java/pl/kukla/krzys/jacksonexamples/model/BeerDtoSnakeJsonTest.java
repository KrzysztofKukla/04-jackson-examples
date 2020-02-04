package pl.kukla.krzys.jacksonexamples.model;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author Krzysztof Kukla
 */
@ActiveProfiles("snake")
public class BeerDtoSnakeJsonTest extends BaseJsonTest {

    @Test
    void serializeJsonToString() throws Exception {
        BeerDto beerDto = getBeerDto();
        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

}
