package equality;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class ObjectEqualityTest {

    @Test
    public void testIfSameObjectIsEqual() {
        Car newCar = new Car("22KY1234","Audi", "R8");
        assertEquals(newCar, newCar);
    }

    @Test
    public void testIfObjectsAreNotReferentiallyEqual() {
        Car currentCar = new Car("12D60113","Volkswagon", "Golf");
        Car newCar = new Car("22KY1234","Audi", "R8");

        // Referential equality
        assertNotEquals(currentCar, newCar);
    }

    @Test
    public void testIfObjectsAreEqualSameValues() {
        Car currentCar = new Car("12D60113","Volkswagon", "Golf");
        Car newCar = new Car("12D60113","Volkswagon", "Golf");

        // Same values but using referential equality (a==b)
        assertNotEquals(currentCar, newCar);
    }

    @Test
    public void testPassingNullAsArgument() {
        assertNotEquals(null, "SETTLE");
        assertEquals(null, null);
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
