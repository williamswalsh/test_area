package equality;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AmbiguousIntTest {

    @Test
    public void name() {
        Map<AmbiguousInteger, Integer> map = new HashMap<>();
        // logically equivalent keys
        AmbiguousInteger key1 = new AmbiguousInteger(1),
                         key2 = new AmbiguousInteger(1),
                         key3 = new AmbiguousInteger(1);

        System.out.println("key1.hashcode: " + key1.hashCode());
        System.out.println("key2.hashcode: " + key2.hashCode());
        System.out.println("key3.hashcode: " + key3.hashCode());

        map.put(key1, 1); // put in value for entry '1'
        map.put(key2, 2); // attempt to override value for entry '1'
        System.out.println(map.get(key1));
        System.out.println(map.get(key2));
        System.out.println(map.get(key3));
    }
}

class AmbiguousInteger {
    private final int value;

    AmbiguousInteger(int value) {
        this.value = value;
    }
}
