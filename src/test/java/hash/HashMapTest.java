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

    @Test
    public void unorderedTest() {
        Map<Integer, Boolean> map = new HashMap<>();

        map.put(1, true);
        map.put(2, true);
        map.put(3, true);
        map.put(4, true);
        map.put(5, true);
        map.put(6, true);
        map.put(7, true);

//        Keys printed in order??
        for(int key: map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}
