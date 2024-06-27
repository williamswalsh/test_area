package tiktok_interview;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class LongestSubstring {
    /*
    abcdaghju
        s
            e

    abcdefaghju
    s
          e
    */
    private static int longestSubString(String str) {
        Map<Character, Integer> present = new HashMap<>();
        int start = 0;
        int end = 0;
        char[] chars = str.toCharArray();
        char currChar;

        while(end < str.length()) {
            currChar = chars[end];
            if (present.containsKey(currChar)) {
                // move start pointer to end
                start = present.get(currChar) + 1;
                // reset
                present.clear();
            } else {
                // Add char to list
                present.put(currChar, end);
                // Increment ptr
                end++;
            }
        }
        return end - start;
    }

    @Test
    public void testLongestSubStringWithAssert() {
        assert 8 == longestSubString("abcdaghju");
    }


    @Test
    public void testLongestSubString() {
        assertEquals(8, longestSubString("abcdaghju"));
    }

    @Test
    public void testLongestSubStringLongestStringAtStart() {
        assertEquals(10, longestSubString("abcdefaghju"));
    }


    @Test
    public void testLongestSubStringSimple() {
        assertEquals(3, longestSubString("abc"));
    }

    @Test
    public void testLongestSubStringSingleChar() {
        assertEquals(1, longestSubString("a"));
    }

    @Test
    public void testLongestSubStringTwoChar() {
        assertEquals(2, longestSubString("ab"));
    }

    @Test
    public void testLongestSubStringWithDuplicateAtEnd() {
        assertEquals(2, longestSubString("aba"));
    }
}
