import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.junit.Test;

public class ConstructorTest {


    @Test
    public void method() {
        Car car = new Car(7);
        Car car1 = new Car();
    }
}

@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Car {
    int numOfWheels;

    Car(int n) {
        numOfWheels = n;
    }
}
