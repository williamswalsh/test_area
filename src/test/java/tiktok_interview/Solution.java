package tiktok_interview;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
/*
Given a string s,
find the length of the longest substring without
repeating characters.
*/
public class Solution {
    /*
    abcdaghju
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
    public void testIoForlongestSubString() {
        assert 8  == longestSubString("abcdaghju");
        assert 10 == longestSubString("abcdefaghju");
        assert 3  == longestSubString("abc");
        assert 1  == longestSubString("a");
        assert 2  == longestSubString("ab");
        assert 2  == longestSubString("aba");
    }
}
