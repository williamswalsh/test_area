package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

/**
 * @JsonSetter allows a specific method to be marked as setter method.
 * Tell Jackson to use setter instead of field reference???
 *
 * This is incredibly useful when we need to read some JSON data,
 * but the target entity class doesn't exactly match that data, and so we need to tune the process to make it fit.
 *
 */
public class JsonSetterTest {
    @Test
    public void jsonSetterTest() {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"rollNo\":1,\"name\":\"Marks\"}";

        try {
            LocalStudent student = mapper.readerFor(LocalStudent.class).readValue(jsonString);
            System.out.println(student.getName());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class LocalStudent {
    public int rollNo;

    // Even if member is private - the value will be set somehow
    private String name;

    // Setter is called only when annotation is present
    // @JsonSetter("name")
    public void setTheName(String name) {
        System.out.println("Setter is called.");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
