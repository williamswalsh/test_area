package jackson;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

public class JsonGetterTest {
    @Test
    public void testJsonGetter() {
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


        // name of method minus the "get" prefix will be the name of the key. studentName: Mark
        // Or you can explicitly call the key something by passing in a string to the annotation
        // @JsonGetter("myCrazyName")
        @JsonGetter("myCrazyName")
        public String getStudentName(){
            return name;
        }
        public int getRollNo(){
            return rollNo;
        }
    }
}


