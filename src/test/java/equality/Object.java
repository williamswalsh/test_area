package equality;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Object {

    @Test
    public void testIfObjectsAreEqual() {
        Car currentCar = new Car("12D60113","Volkswagon", "Golf");
        Car newCar = new Car("22KY1234","Audi", "R8");
        assertFalse(Objects.equals(currentCar, newCar));
        assertTrue(Objects.equals(newCar, newCar));
    }
}

class Car{
    private String registration;
    private String brand;
    private String model;

    public Car(String registration, String brand, String model) {
        this.registration = registration;
        this.brand = brand;
        this.model = model;
    }

    private String getRegistration() {
        return registration;
    }

    private void setRegistration(String registration) {
        this.registration = registration;
    }

    private String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    private String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }
}
