package string_testing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringTest {

    @Test
    public void substringMethodTest() {
        String sample = "ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss";
        assertEquals(199, sample.substring(0,199).length());
    }

    @Test
    public void substringMethodWithStringBuilderTest() {
        StringBuilder sample = new StringBuilder("sssssx");
        System.out.println(sample.length());
        if(sample.length() > 5) {
            System.out.println(sample.substring(0, 5));
        }
        System.out.println(sample.toString());
    }

    @Test
    public void combineErrors() {
        StringBuilder combinedError = new StringBuilder("hell");

        int maxErrorLength = 4;

        if(combinedError.length() > maxErrorLength) {
            System.out.println(combinedError.substring(0, maxErrorLength));
        }
        System.out.println(combinedError.toString());
    }
}
