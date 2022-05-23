package jackson;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

public class JacksonInjectTest {

    // @JacksonInject is used when a property value is to be injected instead of being parsed from Json input.
    // In the example below, we are inserting a value into object instead of parsing from the Json.
    @Test
    public void test() {

        // Json
        String json = "{\"name\":\"Mark\"}";

        // Injected value
        InjectableValues injectableValues = new InjectableValues.Std()
                .addValue(int.class, 1)
                .addValue(String.class, "10023087");

        ObjectMapper mapper = new ObjectMapper();
        try {
            AStudent student = mapper
                    .reader(injectableValues)   // Pass values to reader
                    .forType(AStudent.class)
                    .readValue(json);           // then read the Json string to Object
            System.out.println(student.rollNo + ", " + student.name+ ", " + student.id);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class AStudent {
    public String name;
    @JacksonInject
    public int rollNo;

    @JacksonInject
    public String id;
}
