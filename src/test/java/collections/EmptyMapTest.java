package collections;

import org.junit.Test;

import java.util.Collections;
import java.util.Map;

public class EmptyMapTest {

    @Test(expected = UnsupportedOperationException.class)
    public void testingEmptyMap() {
        Map<String, String> test = Collections.emptyMap();
        test.put("A", "Apple");
    }
}
