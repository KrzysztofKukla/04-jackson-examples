package pl.kukla.krzys.jacksonexamples.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * @author Krzysztof Kukla
 */
//in SpringBoot @JsonTest annotation allows to bring up slice context of Spring - only for Json environment
//in Spring Boot by default it is Jackson - we can change it in configuration
@JsonTest
public class BaseJsonTest {

    @Autowired
    ObjectMapper objectMapper;

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
