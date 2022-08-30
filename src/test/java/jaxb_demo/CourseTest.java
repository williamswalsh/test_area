package jaxb_demo;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.Arrays;

public class CourseTest {

    @Test
    public void testMarshallingObjectToXml() throws JAXBException {
        Course course = new Course();
        course.outcomes = Arrays.asList( "outcome a", "outcome b");
        System.out.println(course);

        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Course.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(course, System.out);
    }
}
