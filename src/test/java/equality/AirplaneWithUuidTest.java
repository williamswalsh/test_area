package equality;

import equality.model.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AirplaneWithUuidTest {

    @Test
    public void reflexiveTest() {
        // Reflexive
        // a.equals(a) should return true.
        AirplaneWithUuid a = new AirplaneWithUuid(UUID.randomUUID(), Make.AIRBUS, Model.A380);
        assertEquals(a, a);
    }

    @Test
    public void symmetricTest() {
        // Symmetric
        // If a.equals(b) returns true, then b.equals(a) must return true.
        UUID uuid = UUID.randomUUID();
        AirplaneWithUuid a = new AirplaneWithUuid(uuid, Make.AIRBUS, Model.A380);
        AirplaneWithUuid b = new AirplaneWithUuid(uuid, Make.AIRBUS, Model.A380);

        assertEquals(a, b);
        assertEquals(b, a);
    }

    @Test
    public void nonEqualsTest() {
        // Symmetric
        // If a.equals(b) returns true, then b.equals(a) must return true.
        AirplaneWithUuid a = new AirplaneWithUuid(UUID.randomUUID(), Make.AIRBUS, Model.A380);
        AirplaneWithUuid b = new AirplaneWithUuid(UUID.randomUUID(), Make.BOEING, Model.SEVEN_SEVEN_SEVEN_DREAMLINER);

        assertNotEquals(a, b);
    }

    @Test
    public void transitiveTest() {
        //Transitive
        // For any reference values a, b, and c
        // if a.equals(b) returns true and b.equals(c) returns true,
        // then a.equals(c) should return true.
        UUID uuid = UUID.randomUUID();
        AirplaneWithUuid a = new AirplaneWithUuid(uuid, Make.AIRBUS, Model.A380);
        AirplaneWithUuid b = new AirplaneWithUuid(uuid, Make.AIRBUS, Model.A380);
        AirplaneWithUuid c = new AirplaneWithUuid(uuid, Make.AIRBUS, Model.A380);

        assertEquals(a, b);
        assertEquals(b, c);
        // Then
        assertEquals(a, c);
    }

    @Test
    public void consistentTest() {
        //Consistent
        // For any reference values a and b
        // multiple invocations of a.equals(b) consistently return true or consistently return false,
        AirplaneWithUuid a = new AirplaneWithUuid(UUID.randomUUID(), Make.AIRBUS, Model.A380);
        assertEquals(a, a);
        assertEquals(a, a);
        assertEquals(a, a);
    }


    @Test
    public void hashCodeEqualTest() {
        // Same uuid, make & model.
        // Same value.
        UUID uuid = UUID.randomUUID();
        AirplaneWithUuid a = new AirplaneWithUuid(uuid, Make.AIRBUS, Model.A380);
        AirplaneWithUuid b = new AirplaneWithUuid(uuid, Make.AIRBUS, Model.A380);

        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void hashCodeNotEqualTest() {
        /**
         * Same uuid different model data field value >> different hashcode
         */
        UUID uuid = UUID.randomUUID();
        AirplaneWithUuid a = new AirplaneWithUuid(uuid, Make.AIRBUS, Model.A380);
        AirplaneWithUuid b = new AirplaneWithUuid(uuid, Make.AIRBUS, Model.A330);

        assertNotEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void hashCodeHashMapTest() {
        Map<AirplaneWithUuid, Integer> stockCount = new HashMap<>();

        AirplaneWithUuid a = new AirplaneWithUuid(UUID.randomUUID(), Make.AIRBUS, Model.A380);
        AirplaneWithUuid b = new AirplaneWithUuid(UUID.randomUUID(), Make.AIRBUS, Model.A330);
        AirplaneWithUuid c = new AirplaneWithUuid(UUID.randomUUID(), Make.BOEING, Model.SEVEN_SEVEN_SEVEN_DREAMLINER);

        System.out.println("a: " + a.hashCode());
        System.out.println("b: " + b.hashCode());
        System.out.println("c: " + c.hashCode());
        stockCount.put(a, 2);
        stockCount.put(b, 3);
        stockCount.put(c, 4);
        System.out.println("stockCount: " + stockCount);
        stockCount.forEach((k,v) -> System.out.println(k + " -> " + v));
    }


    // If you only override the equals() method - mandating that objects with the same uuid are equal,
    // then when you have 2 objects that are "equal" in your business rules, those objects should return the same value
    // for hashcode.
    // hashcode is used by multiple implementations of data Structures to control
    @Test
    public void sameIdentityDifferentBucketInMapTest() {
        Map<AirplaneWithUuid, Integer> stockCount = new HashMap<>();
        UUID commonUuid = UUID.randomUUID();

        // Equality is based upon uuid field only.
        // So these 2 airplanes are equal with regard to our application business rules.
        AirplaneWithUuid a = new AirplaneWithUuid(commonUuid, Make.AIRBUS, Model.A380);
        AirplaneWithUuid b = new AirplaneWithUuid(commonUuid, Make.AIRBUS, Model.A330);

        System.out.println("a hashcode: " + a.hashCode());
        System.out.println("b hashcode: " + b.hashCode());
        stockCount.put(a, 2);
        stockCount.put(b, 3);
        System.out.println("stockCount: " + stockCount);
        stockCount.forEach((k,v) -> System.out.println(k + " -> " + v));
    }
}