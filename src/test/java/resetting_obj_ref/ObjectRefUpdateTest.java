package resetting_obj_ref;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ObjectRefUpdateTest {

    @Test
    public void changeObjectReferenceValueTest() {
        Human a = new Human("Alice");

        changeWhatObjectTheParamRefPointsTo(a);

//        I.E. object ref is not updated in calling method when it is updated in called method.
        assertEquals("Alice", a.name);
    }


    public void changeWhatObjectTheParamRefPointsTo(Human human) {
        human = new Human("Bob");
    }
}
class Human {
    String name;

    public Human(String name) {
        this.name = name;
    }
}
