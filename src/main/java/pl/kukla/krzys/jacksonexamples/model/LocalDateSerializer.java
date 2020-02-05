package pl.kukla.krzys.jacksonexamples.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Krzysztof Kukla
 */
public class LocalDateSerializer extends JsonSerializer<LocalDate> {
    @Override
    public void serialize(LocalDate value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        //it changes format for value to BASIC
        String valueFormat = value.format(DateTimeFormatter.BASIC_ISO_DATE);

        //then save object with such format
        jsonGenerator.writeObject(valueFormat);
    }

}
