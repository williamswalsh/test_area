package jackson;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

/**
 * This annotation allows for a default value of a enum while you are deserializing the json to an Object
 *
 * Use-case:
 * When you have an enum value in a JSON and you want to create a default if unknown values are given
 * This annotation will convert the unknowns to the set default,
 * so that your object will never have unknown values.
 */
public class JsonEnumDefaultValueTest {

    @Test
    public void jsonEnumDefaultValueTest() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE);
        String jsonString = "\"abc\"";
        try {
            LETTERS value = mapper
                    .readValue(jsonString, LETTERS.class);

            System.out.println(value);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    enum LETTERS {
        A, B, @JsonEnumDefaultValue UNKNOWN
    }
}
