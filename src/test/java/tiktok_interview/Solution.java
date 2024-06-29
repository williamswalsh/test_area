package tiktok_interview;

import hash.HashMapTest;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/*
Given a string s,
find the length of the longest substring without
repeating characters.
*/
public class Solution {

    private static int longestSubString(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int maxLength = 0;
        Set<Character> present = new LinkedHashSet<>();

        for(int right = 0; right < chars.length; right++) {
            if (!present.contains(chars[right])) {
                present.add(chars[right]);
                maxLength = Math.max(maxLength, right - left + 1);
            } else {

//                Key piece of code - Start
                while(present.contains(chars[right])) {
                    present.remove(chars[left]);
                    left++;
                }
                present.add(chars[right]);
//                Key piece of code - END
            }
        }
        return maxLength;
    }

    @Test
    public void testLongestSubString() {
        assert 3  == longestSubString("abcabcbb");
        assert 2  == longestSubString("abba");
        assert 8  == longestSubString("abcdaghju");
        assert 10 == longestSubString("abcdefaghju");
        assert 7 == longestSubString("abcdefeghijki");
        assert 3  == longestSubString("abc");
        assert 1  == longestSubString("a");
        assert 2  == longestSubString("ab");
        assert 2  == longestSubString("aba");
    }
}
