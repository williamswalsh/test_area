package string_testing;

import org.junit.Test;

import java.text.MessageFormat;

import static org.junit.Assert.assertEquals;

public class StringTest {

    @Test
    public void stringFormatTesting() {
        String specifiedLanguage = "fr";
        String FALLBACK_LANG = "en";
        String expected = "No manuals are available for the languages - chosen language: fr, region fallback language: en";
        assertEquals(expected, MessageFormat.format("No manuals are available for the languages - chosen language: {0}, region fallback language: {1}", specifiedLanguage, FALLBACK_LANG));
    }


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
