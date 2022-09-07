package jackson.construction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jackson.JsonGetterTest;
import org.junit.Test;

public class ObjectToJson {

    @Test
    public void serialiseObjectToJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Car futureCar = new Car(4, "Ferrari", "F12 berlinetta");
        String jsonString = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(futureCar);

        Car user = mapper.readValue(jsonString, Car.class);
    }
}
