package varargs;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author William Walsh
 * @version 18 Oct 2022
 */
public class TestVarargsOperator {

    @Test
    public void testWithOneParameter() {
        dummyMethod("one");
    }

    @Test
    public void testWithTwoParameters() {
        dummyMethod("one", "two");
    }

    @Test
    public void testWithThreeParameters() {
        dummyMethod("one", "two", "three");
    }

    @Test
    public void testWithOneParameter_getType() {
        getTypeMethod("one");
    }

    @Test
    public void testWithTwoParameters_getType() {
        getTypeMethod("one", "two");
    }


    private void getTypeMethod(String... strings) {
        System.out.println("Object Type: " + strings.getClass());
    }

    private void dummyMethod(String... strings) {
        List<String> list = Arrays.asList(strings);
        list.forEach(System.out::println);
    }
}
