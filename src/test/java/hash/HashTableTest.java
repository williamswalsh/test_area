package hash;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Hashtable;

import static org.junit.Assert.assertEquals;

/**
 * HashTable is deprecated from Java1.8(8).
 * Thread safe - Can be shared by multiple threads in the application.
 * key.hashCode() % size of HashTable
 * index = hashCode() % 10
 * Best Case:  O(1) constant time - fast insertion & retrieval
 * Worst Case: O(n) linear time   - as the bucket is a linked-list which contains all the values.
 */
public class HashTableTest {


    @Test(expected = NullPointerException.class)
    public void hashTableCantHaveNullKeyAndValueTest() {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();

        // NPE thrown when adding a key or a value with value null.
        hashtable.put(null,null);
    }

    @Test(expected = NullPointerException.class)
    public void hashTableCantHaveNullKeyTest() {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        hashtable.put(null,1);
    }

    @Test(expected = NullPointerException.class)
    public void hashTableCantHaveNullValueTest() {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        hashtable.put(1,null);
    }

    @Test
    public void hashTableListValuesTest() {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        hashtable.put(1,11);
        hashtable.put(2,22);
        hashtable.put(3,33);
        hashtable.put(4,44);

        // No ConcurrentModificationException when modifying
        Enumeration<Integer> values = hashtable.elements();

        while (values.hasMoreElements()) {
            System.out.println(values.nextElement());
            hashtable.remove(3);
        }
        assertEquals(3, hashtable.size());
    }
}
