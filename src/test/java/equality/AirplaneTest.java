package equality;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import equality.model.*;

import static org.junit.Assert.*;

public class AirplaneTest {

    @Test
    public void reflexiveTest() {
        // Reflexive
        // a.equals(a) should return true.
        equality.model.Airplane a = new equality.model.Airplane(Make.AIRBUS, Model.A380);
        assertEquals(a, a);
    }

    @Test
    public void symmetricTest() {
        // Symmetric
        // If a.equals(b) returns true, then b.equals(a) must return true.
        equality.model.Airplane a = new equality.model.Airplane(Make.AIRBUS, Model.A380);
        equality.model.Airplane b = new equality.model.Airplane(Make.AIRBUS, Model.A380);

        assertEquals(a, b);
        assertEquals(b, a);
    }

    @Test
    public void nonEqualsTest() {
        // Symmetric
        // If a.equals(b) returns true, then b.equals(a) must return true.
        equality.model.Airplane a = new equality.model.Airplane(Make.AIRBUS, Model.A380);
        equality.model.Airplane b = new equality.model.Airplane(Make.BOEING, Model.SEVEN_SEVEN_SEVEN_DREAMLINER);

        assertNotEquals(a, b);
    }

    @Test
    public void transitiveTest() {
        //Transitive
        // For any reference values a, b, and c
        // if a.equals(b) returns true and b.equals(c) returns true,
        // then a.equals(c) should return true.
        equality.model.Airplane a = new equality.model.Airplane(Make.AIRBUS, Model.A380);
        equality.model.Airplane b = new equality.model.Airplane(Make.AIRBUS, Model.A380);
        equality.model.Airplane c = new equality.model.Airplane(Make.AIRBUS, Model.A380);

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
        equality.model.Airplane a = new equality.model.Airplane(Make.AIRBUS, Model.A380);
        assertEquals(a, a);
    }


    @Test
    public void hashCodeEqualTest() {
        equality.model.Airplane a = new equality.model.Airplane(Make.AIRBUS, Model.A380);
        equality.model.Airplane b = new equality.model.Airplane(Make.AIRBUS, Model.A380);

        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void hashCodeNotEqualTest() {
        equality.model.Airplane a = new equality.model.Airplane(Make.AIRBUS, Model.A380);
        equality.model.Airplane b = new equality.model.Airplane(Make.AIRBUS, Model.A330);

        assertNotEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void hashCodeHashMapTest() {
        Map<equality.model.Airplane, Integer> stockCount = new HashMap<>();

        equality.model.Airplane a = new equality.model.Airplane(Make.AIRBUS, Model.A380);
        equality.model.Airplane b = new equality.model.Airplane(Make.AIRBUS, Model.A330);
        equality.model.Airplane c = new equality.model.Airplane(Make.BOEING, Model.SEVEN_SEVEN_SEVEN_DREAMLINER);


    }
}