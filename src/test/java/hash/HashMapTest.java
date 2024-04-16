package hash;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * When to use:
 * - for a unsynchronised/single threaded application
 *
 * map.get(); - get value at key
 * map.put(); - put value at key
 * map.putIfAbsent(); - put value at key if key doesn't already exist. If it exists, don't put it. Like a default value.
 * map.replace() - replace the value if the key exist already - otherwise don't do anything.
 * map.containsKey(); - does map contain the key
 * map.containsValue(); - does map contain the value
 */
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

        // Order of integers is not ensured.
        for(int key: map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }

    @Test
    public void nullValueCountsAsKeyTest() {
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(1, true);
        map.put(2, false);
        map.put(null, true);    // This counts as a unique key.
        map.put(4, true);
        assertEquals(4, map.size());
    }


    @Test(expected = NullPointerException.class)
    public void iterateMapTest() {
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(1, true);
        map.put(2, false);
        map.put(null, true);    // This counts as a unique key.
        map.put(4, true);

        // This will cause a NPE - as 1 key has the value of null
        for(int i: map.keySet()) {
            System.out.println(i);
        }
    }

    @Test(expected = ConcurrentModificationException.class)
    public void modifyWhileIterateKeySetTest() {
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(1, true);
        map.put(2, false);
        map.put(null, true);    // This counts as a unique key.
        map.put(4, true);
        Iterator<Integer> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            iterator.next();
            map.remove(4);
        }
        System.out.println(map);
    }

    /**
     * No ConcurrentModificationException exception.
     */
    @Test
    public void modifyWhileIterateEntrySetTest() {
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(1, true);
        map.put(2, false);
//        map.put(null, true);    // This counts as a unique key.
        map.put(4, true);
        Iterator<Map.Entry<Integer, Boolean>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Boolean> entry = iterator.next();
//            entry.getKey();
//            entry.getValue();

            // Equivalent to map.remove(4);
            if (4 == entry.getKey()) {
                iterator.remove();
            }

        }
        System.out.println(map);
    }

    @Test
    public void sychronisedMap() {
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(1, true);
        map.put(2, false);
//        map.put(null, true);    // This counts as a unique key.
        map.put(4, true);
        Map<Integer, Boolean> synchronisedHashMap = Collections.synchronizedMap(map);


    }
}
