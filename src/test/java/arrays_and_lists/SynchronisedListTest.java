package arrays_and_lists;

import org.junit.Test;
import java.util.*;

public class SynchronisedListTest {


    @Test
    public void synchronisedListTest() {
        List<String> strs = new ArrayList<>();
        strs.add("a");
        strs.add("b");
        strs.add("c");
        strs.add("d");
        strs.add("e");
        strs.add("f");
        List<String> list = Collections.synchronizedList(strs);

        synchronized (list) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
