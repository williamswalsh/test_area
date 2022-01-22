package jackson_test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

public class JacksonTest {

    @Test
    public void objectToJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Car user = new Car(4, 1999L, 1999L);

        //Object to JSON in file
        // mapper.writeValue(new File("/users/will/Downloads/user.txt"), user);

        //Object to JSON in String
        String jsonInString = mapper.writeValueAsString(user);
        System.out.println(jsonInString);
    }

    @Test
    public void jsonToObject() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String objAsStr = "{\"numOfWheels\":4,\"cc\": null,\"ccPrimitive\": null}";

        //JSON from String to Object
        Car car = mapper.readValue(objAsStr, Car.class);
        System.out.println(car.ccPrimitive);
        System.out.println(car.cc);
    }

}
class Car {
    public int numOfWheels;
    public Long cc;
    public long ccPrimitive;

    public Car() {
    }

    public Car(int numOfWheels, Long cc, long ccPrimitive) {
        this.numOfWheels = numOfWheels;
        this.cc = cc;
        this.ccPrimitive = ccPrimitive;
    }
}
