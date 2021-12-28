import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ForEachTesting {

    @Test
    public void when_for_each_passed_null_outcome() {
        List<String> list = null;

        for (String s: list) {
            System.out.println(s);
        }
    }

    @Test
    public void can_list_add_null_value() {
        List<String> strings = new ArrayList<>();
        strings.add(null);
        strings.add("2nd");

        for(String s: strings) {
            System.out.println(s);
        }
    }
}
