package instanceOf;

import org.junit.Test;

/**
 * @author William Walsh
 * @version 02 Oct 2022
 */
public class InstanceOfTest {



    @Test
    public void instanceOfWithNull() {
        Integer i = null;

        boolean result = i instanceof Integer; // false

        System.out.println(result);
    }
}
