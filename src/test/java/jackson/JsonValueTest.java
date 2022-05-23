package jackson;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

public class JsonValueTest {

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


    class Student {
        private String name;
        private int rollNo;
        public Student(String name, int rollNo){
            this.name = name;
            this.rollNo = rollNo;
        }
        public String getName(){
            return name;
        }
        public int getRollNo(){
            return rollNo;
        }

        /*
        This can be used to control what the json value of an object would be.
        Here we are only using one member of the class.
        Probably not recommended as it relies on string concatenation
        Try removing it to test what the default value would be.
         */
        @JsonValue
        public String toString(){
            return "{ name : " + name + " }";
        }
        // With
        //{ name : Mark }

        // Without
        // {
        //   "name" : "Mark",
        //   "rollNo" : 1
        // }
    }
}
