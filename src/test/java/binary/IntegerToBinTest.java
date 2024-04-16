package binary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerToBinTest {

    @Test
    public void intToBinTest() {
        int i = 64;
        String actual = Integer.toBinaryString(i);
        String expected = "1000000";
        assertEquals(expected, actual);
    }
}
