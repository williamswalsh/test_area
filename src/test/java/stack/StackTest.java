package stack;

import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.Assert.assertNull;

public class StackTest {

    @Test
    public void pushNullOntoStackTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(null);
        assertNull(stack.pop());
    }

    @Test(expected = EmptyStackException.class)
    public void popWithEmptyStackTest() {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.pop());
    }
}
