package arrays_and_lists;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class LinkedListTest {

    @Test
    public void llAddTest() {
        LinkedList<Integer> ll = new LinkedList<>();

//      This add will append a new element onto the end of the ll
//      The next node ptr will be updated to point at the new node(value: 1)
//      The added node next ptr will point to null(the end of the list).
//      Constant time
//      O(1)
//      No traversal needed.
//      There is even a method to get the last element -> getLast()
        ll.add(1);
//        getLast() -> create new node -> update last nextPtr to point at new node
    }

    @Test
    public void llGetIndexTest() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);

//        Get method only has one version.
//        The method has a single parameter called "index".
//        The index is the position of the element in the ll.
//        Get elem at index.
//        O(n) - traversal required
        int i = ll.get(5);
        assertEquals(6, i);
    }

    @Test
    public void llAddIndexElemTest() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);

//      Inserts the given value at the given index.
        ll.add(5, 7);
        System.out.println(ll);
    }

    @Test
    public void llRemoveNoArgTest() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);

//        remove() no-args removes the head
        ll.remove();
        assertEquals(2, (int) ll.getFirst());
    }

    @Test
    public void llRemoveElemTest() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);

//        .remove(Object o);
//        Remove the actual object
//        Have to find the object to get remove it -> O(n)
        ll.remove(Integer.valueOf(4));
        assertFalse(ll.contains(4));
    }

    @Test
    public void llRemoveIndexTest() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);

//        .remove(index);
//        Remove the object at index
//        Have to traverse nodes to get to reach index - in order to remove it
//        Linear time - O(n)
        ll.remove(0);
        assertFalse(ll.contains(1));
    }


}
