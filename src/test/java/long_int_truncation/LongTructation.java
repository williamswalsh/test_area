package long_int_truncation;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LongTructation {

    @Test
    public void testIfLongIsTruncatedByIntCast() {

        Map<String, Object> searchResponse = new HashMap<>();
        searchResponse.put("id", "");
        searchResponse.put("small_number", 1234);
        searchResponse.put("big_long", 9223372036854775807L);
        searchResponse.put("big_number", 111111111);

        // int value stored in map
        System.out.println(searchResponse.get("small_number"));
        System.out.println(((Integer) searchResponse.get("small_number")));
        System.out.println(((Integer) searchResponse.get("small_number")).longValue());

        // long value stored in map
        System.out.println(searchResponse.get("big_long"));
        // System.out.println(((Integer) searchResponse.get("big_long")));
        // System.out.println(((Integer) searchResponse.get("big_long")).longValue());
    }
}
