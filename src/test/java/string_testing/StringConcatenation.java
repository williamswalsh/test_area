package string_testing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringConcatenation {

    @Test
    public void testIntegerBeforeStringConcatenation() {
        // will combine int and string to string -> like in JS
        String actual = 10 + "hello";
        String expected = "10hello";
        assertEquals(expected, actual);
    }
}
