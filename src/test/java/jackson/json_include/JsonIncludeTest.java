package jackson.json_include;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class JsonIncludeTest {

    @Test
    public void listWithElementsTest() throws JsonProcessingException {
        Student student = new Student("liam", "mail", "person@domain.com", "08723456789",
                Arrays.asList("Maths", "Java", "Docker"));
        ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String expected = "{\n"
                + "  \"firstName\" : \"liam\",\n"
                + "  \"lastName\" : \"mail\",\n"
                + "  \"email\" : \"person@domain.com\",\n"
                + "  \"mobileNumber\" : \"08723456789\",\n"
                + "  \"courses\" : [ \"Maths\", \"Java\", \"Docker\" ]\n"
                + "}";
        String actual = writer.writeValueAsString(student);
        assertEquals(expected, actual);
    }

    @Test
    public void emptyListTest() throws JsonProcessingException {
        Student student = new Student("liam", "mail", "person@domain.com", "08723456789",
                Collections.emptyList());
        ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String actual = writer.writeValueAsString(student);
        String expected = "{\n"
                + "  \"firstName\" : \"liam\",\n"
                + "  \"lastName\" : \"mail\",\n"
                + "  \"email\" : \"person@domain.com\",\n"
                + "  \"mobileNumber\" : \"08723456789\",\n"
                + "  \"courses\" : [ ]\n"
                + "}";
        assertEquals(expected, actual);
    }

    @Test
    public void nullListTest() throws JsonProcessingException {
        Student student = new Student("liam", "mail", "person@domain.com", "08723456789",
                null);
        ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String expected = "{\n"
                + "  \"firstName\" : \"liam\",\n"
                + "  \"lastName\" : \"mail\",\n"
                + "  \"email\" : \"person@domain.com\",\n"
                + "  \"mobileNumber\" : \"08723456789\"\n"
                + "}";
        String actual = writer.writeValueAsString(student);
        assertEquals(expected, actual);
    }

    @Test
    public void nullListOnlyClassVariableTest() throws JsonProcessingException {
        JustAList list = new JustAList(null);
        ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String expected = "{ }";
        String actual = writer.writeValueAsString(list);
        assertEquals(expected, actual);
    }

    @Test
    public void nullListNoIncludeStatementTest() throws JsonProcessingException {
        JustAList list = new JustAList(null);
        ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String expected = "{ }";
        String actual = writer.writeValueAsString(list);
        assertEquals(expected, actual);
    }
}

// It includes all non_null inputs, i.e. it won't include null
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
class Student {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String mobileNumber;
    private final List<String> courses;
}

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
class JustAList {
    private final List<String> list;
}