package jackson;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @JsonAnySetter allows a setter method to use Map which is then used to deserialize
 * the additional properties of JSON in the similar fashion as other properties.
 *
 * So this annotation is used when you:
 * - have a json string
 * - have an object which has a hashmap of key-value pairs instead of members
 * - want to create an Object from your Json string
 */
public class JsonAnySetterTest {

    @Test
    public void test() {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"RollNo\" : \"1\",\"Name\" : \"Mark\"}";
        try {
            Student student = mapper
                    .readerFor(Student.class)
                    .readValue(jsonString);

            System.out.println(student.getProperties().get("Name"));
            System.out.println(student.getProperties().get("RollNo"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Student {
    private Map<String, String> properties;
    public Student(){
        properties = new HashMap<>();
    }
    public Map<String, String> getProperties(){
        return properties;
    }

    // Telling Jackson to use this method if there are any keys value pairs inside the json
    // "name": "william"
    // this method will be called like:
    // object.add("name", "william")
    @JsonAnySetter
    public void add(String property, String value){
        properties.put(property, value);
    }
}