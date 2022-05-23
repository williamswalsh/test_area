package jackson;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.IOException;

public class JsonRootNameTest {

    @Test
    public void test() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Student student = new Student("Mark", 1);

            //Have to enable that setting
            // Without this the Annotation has no effect
            mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

            String jsonString = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(student);
            System.out.println(jsonString);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @JsonRootName(value = "student")
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
    }
    // With annotation and feature enabling
    //{
    //   "student" : {
    //     "name" : "Mark",
    //     "rollNo" : 1
    //   }
    // }

    // Without annotation, with feature enabling
    // {
    //   "Student" : {
    //     "name" : "Mark",
    //     "rollNo" : 1
    //   }
    // }

    // Without annotation, without feature enabling - mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
    // {
    //     "name" : "Mark",
    //     "rollNo" : 1
    // }
}

