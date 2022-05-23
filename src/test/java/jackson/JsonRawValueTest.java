package jackson;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

public class JsonRawValueTest {

    @Test
    public void test() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Student student = new Student("Mark", 1, "{\"attr\":false}");
            String jsonString = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(student);
            System.out.println(jsonString);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Student {
        private String name;
        private int rollNo;


        // Marks a String member
        // Tells jackson to serialize a property exactly as is
        @JsonRawValue
        private String json;

        public Student(String name, int rollNo, String json){
            this.name = name;
            this.rollNo = rollNo;
            this.json = json;
        }
        public String getName(){
            return name;
        }
        public int getRollNo(){
            return rollNo;
        }
        public String getJson(){
            return json;
        }
    }

    // Without:
    // {
    //   "name" : "Mark",
    //   "rollNo" : 1,
    //   "json" : "{\"attr\":false}"
    // }

    // With:  @JsonRawValue
    //{
    //   "name" : "Mark",
    //   "rollNo" : 1,
    //   "json" : {"attr":false}
    // }
}
