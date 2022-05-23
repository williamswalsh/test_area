package string_testing;

import org.junit.Test;

public class StringRegex {

    @Test
    public void understandRegex() {
        String urlStr = "https://www.google.com/search?a=4&b=3";
        System.out.println(urlStr.replaceAll("\\.", ""));
    }
}
