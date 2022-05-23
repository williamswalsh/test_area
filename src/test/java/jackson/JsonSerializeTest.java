package jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// @JsonSerialize is used to specify custom serializer to marshall the json object.
//
// Marshall - assemble and arrange (a group of people, especially troops) in order.
public class JsonSerializeTest {

    @Test
    public void jsonSerializeTest() throws ParseException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Student student = new Student("Mark", 1, dateFormat.parse("20-11-1984"));
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
        // @JsonSerialize(using = CustomDateSerializer.class)
        private Date dateOfBirth;
        public Student(String name, int rollNo, Date dob){
            this.name = name;
            this.rollNo = rollNo;
            this.dateOfBirth = dob;
        }
        public String getName(){
            return name;
        }
        public int getRollNo(){
            return rollNo;
        }
        public Date getDateOfBirth(){
            return dateOfBirth;
        }
    }
}

class CustomDateSerializer extends StdSerializer<Date> {
    private static final long serialVersionUID = 1L;
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    public CustomDateSerializer() {
        this(null);
    }
    public CustomDateSerializer(Class<Date> t) {
        super(t);
    }
    @Override
    public void serialize(Date value,
            JsonGenerator generator, SerializerProvider arg2) throws IOException {
        generator.writeString(formatter.format(value));
    }
}
