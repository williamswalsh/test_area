package jaxb_demo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "course")
public class Course {

    // @JacksonXmlElementWrapper(localName = "outcomes") //localName = "outcomes")
    @JsonProperty(value = "outcome")
    public List<String> outcomes;

    @Override
    public String toString() {
        return "Course{" +
                "outcomes=" + outcomes +
                '}';
    }
}
