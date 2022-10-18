package collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsListTest {

    @Test
    public void testArraysAsList_IntArray() {
        List<Integer> l = Arrays.asList(3, 5, 6);
        List<String> strs = new ArrayList<>();
    }

    @Test
    public void testArraysAsList_StringArray() {

        List<String> skills =  Arrays.asList("machine learning", "deep learning");
        for(String skill: skills) {
            System.out.println("Skill: " + skill);
        }
    }
}
