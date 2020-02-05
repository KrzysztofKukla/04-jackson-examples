package pl.kukla.krzys.jacksonexamples.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
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

    //explicitly tells Json to treat 'price' as String
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;

    //treat as String and specify date format
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private OffsetDateTime createdDate;

    private OffsetDateTime lastUpdatedDate;

    //it uses custom LocalDateSerializer class to serialize Date
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate myLocalDate;

}
