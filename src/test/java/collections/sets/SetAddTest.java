package collections.sets;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author William Walsh
 * @version 19 Oct 2022
 */
public class SetAddTest {
    @Test
    public void method() {
        Set<String> strings = new HashSet<>();

        System.out.println(!strings.add("a"));
        System.out.println(!strings.add("a"));
    }
}
