package hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    @Test
    public void hashMapNullTest() {
        Map<Integer, Boolean> intPresenceMap = new HashMap<>();

        // No exception is thrown from any of these lines of code:
        intPresenceMap.put(null, null);
        intPresenceMap.put(7, null);
        intPresenceMap.put(null, true);

    }
}
