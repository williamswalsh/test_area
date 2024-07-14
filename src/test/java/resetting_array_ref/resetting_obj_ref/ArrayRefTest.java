package resetting_array_ref.resetting_obj_ref;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayRefTest {

    @Test
    public void changeObjectReferenceValueTest() {
        int[] a = new int[10];

        changeWhatArrayRefPointsTo(a);

//        I.E. array ref is not updated in calling method when it is updated in called method.
        assertEquals(10, a.length);
    }

    public void changeWhatArrayRefPointsTo(int[] a) {
        a = new int[15];
    }
}
