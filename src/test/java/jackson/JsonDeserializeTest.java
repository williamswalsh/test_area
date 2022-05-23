package jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @JsonDeserialize is used to specify custom deserializer to unmarshall the json object.
 *
 * Use this when you have serial data - json data in a file
 * and you want to de-serialize the data - into a java object so we can process it
 * but you want to convert the typed date into a format that you need
 * like if you were moving multiple instances of the data from a file to the DB
 */
public class JsonDeserializeTest {
    @Test
    public void jsonDeserializeTest() {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mark\",\"dateOfBirth\":\"20-12-1984\"}";
        try {
            AgainAStudent student = mapper
                    .readerFor(AgainAStudent.class)
                    .readValue(jsonString);
            System.out.println(student.dateOfBirth);    // Thu Dec 20 00:00:00 GMT 1984
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class AgainAStudent {
    public String name;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public Date dateOfBirth;
}

class CustomDateDeserializer extends StdDeserializer<Date> {
    private static final long serialVersionUID = 1L;
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    public CustomDateDeserializer() {
        this(null);
    }

    public CustomDateDeserializer(Class<Date> t) {
        super(t);
    }
    @Override
    public Date deserialize(JsonParser parser, DeserializationContext context)
            throws IOException {

        String date = parser.getText();
        try {
            return formatter.parse(date);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}