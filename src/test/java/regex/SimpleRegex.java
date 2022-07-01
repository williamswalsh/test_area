package regex;

import org.junit.Test;

import java.util.regex.Pattern;

public class SimpleRegex {

    @Test
    public void testSimpleRegex() {
        String format = "JSON";
        System.out.println(Pattern.compile("json|xml").matcher(format).matches());
    }
}
