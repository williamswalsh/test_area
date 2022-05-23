package jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

public class JsonCreatorTest {

    @Test
    public void test() {
        String json = "{\"id\":1,\"theName\":\"Mark\"}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            MyStudent student = mapper
                    .readerFor(MyStudent.class)
                    .readValue(json);
            System.out.println(student.rollNo +", " + student.name);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyStudent {
    public String name;
    public int rollNo;

    // This highlights to Jackson what constructor to use.
    // Constructor can be a delegate constructor or a constructor with all JsonProperties
    @JsonCreator
    public MyStudent(@JsonProperty("theName") String name, @JsonProperty("id") int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }

    // NB: StackOverflowError
    // keeps instantiating MyStudent which requires MyStudent
    // cyclic dependency
    // @JsonCreator
    // public MyStudent(MyStudent student){
    //     this.name = student.name;
    //     this.rollNo = student.rollNo;
    // }
}
