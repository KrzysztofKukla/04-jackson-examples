package pl.kukla.krzys.jacksonexamples.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * @author Krzysztof Kukla
 */
public class BaseTest {

    BeerDto getBeerDto() {
        return BeerDto.builder()
            .id(UUID.randomUUID())
            .beerName("aaa")
            .beerStyle("beer style eee")
            .upc(1111122L)
            .price(new BigDecimal("2.19"))
            .createdDate(OffsetDateTime.now())
            .lastUpdatedDate(OffsetDateTime.now())
            .build();
    }

}
