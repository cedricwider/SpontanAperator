package org.aperator.spontan.controller.data.mapper;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 19/04/14
 * Time: 01:29
 */
public class JsonDateFormatter extends JsonSerializer<Date> {

    DateFormat myDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(myDateFormat.format(date));
    }
}
