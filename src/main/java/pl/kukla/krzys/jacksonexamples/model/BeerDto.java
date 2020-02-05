package pl.kukla.krzys.jacksonexamples.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * @author Krzysztof Kukla
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    // it is json property name for id is set up into 'beerId'
    // camelCase is used by default by Jackson unless you define any special strategy in PropertyNamingStrategy
    // but using @JsonProperty you can define name explicitly
    @JsonProperty(value = "beerId")
    @Null
    private UUID id;

    @NotBlank
    private String beerName;

    @NotBlank
    private String beerStyle;

    @Positive
    private Long upc;

    private BigDecimal price;

    private OffsetDateTime createdDate;

    private OffsetDateTime lastUpdatedDate;

}
