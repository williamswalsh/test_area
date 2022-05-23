package string_testing;

import org.junit.Test;

public class ReplaceAllRegex {
    @Test
    public void understandRegex() {
        System.out.println("START_" + " hello world ".replaceAll("\\s+", " ") + "_END");
    }
}
