package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDateSerializerTest {

    @Test
    public void jsonSerializeTest() throws ParseException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Student student = new Student("Mark", 1, dateFormat.parse("20-11-1984"));
            mapper
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .setDateFormat(new StdDateFormat().withColonInTimeZone(true));

            System.out.println(mapper.writeValueAsString(student));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Student {
        private String name;
        private int rollNo;
        private Date dateOfBirth;

        public Student(String name, int rollNo, Date dob) {
            this.name = name;
            this.rollNo = rollNo;
            this.dateOfBirth = dob;
        }

        public String getName() {
            return name;
        }

        public int getRollNo() {
            return rollNo;
        }

        public Date getDateOfBirth() {
            return dateOfBirth;
        }
    }
}
