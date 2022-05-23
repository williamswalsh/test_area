package object_references;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassByValue {

    @Test
    public void testMethodStringRefPassByValue() {
        String salutation = "hello";
        mutator(salutation);
        assertEquals("hello", salutation);
    }

    @Test
    public void testMethodObjectRefPassByValue() {
        Car car = new Car(4, "VW");
        carMutator(car);
        assertEquals("Audi", car.brand);
        System.out.println(car);
    }

    private void mutator(String s) {
        s = "bye";
        System.out.println(s);
    }

    private void carMutator(Car c) {
        c.brand = "Audi";
        System.out.println(c);
    }
}
class Car {
    int numberOfWheels;
    String brand;

    Car(int numberOfWheels, String brand) {
        this.numberOfWheels = numberOfWheels;
        this.brand = brand;
    }
}
