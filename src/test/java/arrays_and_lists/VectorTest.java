package arrays_and_lists;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import static org.junit.Assert.assertEquals;


// Only one thread can call methods on a Vector

public class VectorTest {

    @Test
    public void vectorTest() {
        Vector<Integer> v = new Vector<>();
        v.add(1);
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(5);
        assertEquals(1, (int)v.firstElement());
    }

    @Test
    public void vectorIteratorTest() {
        Vector<Integer> integers = new Vector<>();
        integers.add(1);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(5);

        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

//        Can use enhanced for loop instead of iterator
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    @Test
    public void vectorEnumerationTest() {
        Vector<Integer> v = new Vector<>();
        v.add(1);
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(5);

        Enumeration<Integer> elements = v.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
    }
}
