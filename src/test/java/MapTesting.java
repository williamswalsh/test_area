import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNull;

public class MapTesting {

    @Test
    public void hashmap_when_get_called_with_null_null_output() {
        Map<String,String> map = new HashMap<>();
        map.put("A", "1");
        map.put("B", "2");

        assertNull(map.get(null));
    }

    @Test
    public void hashmap_when_get_called_non_present_key() {
        Map<String,String> map = new HashMap<>();
        map.put("A", "1");
        map.put("B", "2");

        assertNull(map.get("C"));
    }

    @Test
    public void hashmap_when_get_called_null_value() {
        Map<String,String> map = new HashMap<>();
        map.put("A", "1");
        map.put("B", "2");
        map.put("C", null);

        assertNull(map.get("C"));
    }
}
