package jackson;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

public class JsonPropertyOrderTest {

    @Test
    public void test() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Student student = new Student("Mark", 1);
            String jsonString = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(student);
            System.out.println(jsonString);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Can order properties alphabetically:
    // By using:
    // @JsonPropertyOrder(alphabetic=true)
    // or
    // Can have custom order for properties, as follows
    @JsonPropertyOrder({ "rollNo", "name" })
    class Student {
        private String name;
        private int rollNo;
        public Student(String name, int rollNo) {
            this.name = name;
            this.rollNo = rollNo;
        }
        public String getName(){
            return name;
        }
        public int getRollNo(){
            return rollNo;
        }
    }
}
