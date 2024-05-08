package maps;

import org.junit.Test;

import java.util.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class MapsTest {

    @Test
    public void hashMapTest() {
        Map<Integer,String> idToUser = new HashMap<>();

        // doesn't follow insertion order
        idToUser.put(0, "William Walsh");
        idToUser.put(3, "Natalie Walsh");
        idToUser.put(2, "Georgia Barrington-Smith");
        idToUser.put(1, "Samuel Barrington-Smith");

//        0->WW, 1->GBS, 2->SBS, 3->NW
        System.out.println(idToUser);
    }

    @Test
    public void linkedHashMapTest() {
        Map<Integer,String> idToUser = new LinkedHashMap<>();

        // does follow insertion order
        // 0->WW, 3->NW, 2->GBS, 1->SBS
        idToUser.put(0, "William Walsh");
        idToUser.put(3, "Natalie Walsh");
        idToUser.put(2, "Georgia Barrington-Smith");
        idToUser.put(1, "Samuel Barrington-Smith");

        System.out.println(idToUser);
    }

    @Test
    public void treeMapTest() {
        Map<Integer,String> idToUser = new TreeMap<>();

        // TreeMap - orders values by keys natural ordering
        // 0->WW, 1->GBS, 2->SBS, 3->NW
        idToUser.put(0, "William Walsh");
        idToUser.put(3, "Natalie Walsh");
        idToUser.put(2, "Georgia Barrington-Smith");
        idToUser.put(1, "Samuel Barrington-Smith");

        System.out.println(idToUser);
    }

    @Test
    public void treeMapSecondTest() {
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("A", 1);
        treeMap.put("C", 3);
        treeMap.put("B", 2);

        assertEquals(1, (int)treeMap.get("A"));
        treeMap.remove("B");

        System.out.println(treeMap);
        // Iterating over the elements of the tree map
        for (String key : treeMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + treeMap.get(key));
        }
    }

    @Test
    public void synchronisedSortedMapTest() {
        try {
            SortedMap<String, String> map = new TreeMap<>();
            map.put("1", "A");
            map.put("2", "B");
            map.put("3", "C");
            System.out.println("Sorted Map : " + map);

//            This returns "a view" to the map -> not the original map
            SortedMap<String, String> sortedmap = Collections.synchronizedSortedMap(map);

//            Can edit the map by using the overlying view
            sortedmap.put("4", "D");
            System.out.println("Synchronized sorted map is :" + sortedmap);
        }

        catch (IllegalArgumentException e) {
            System.out.println("Exception thrown : " + e);
    }
        }
    }
