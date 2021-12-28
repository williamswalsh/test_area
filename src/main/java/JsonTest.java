import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("A", "1");
        map.put("B", "2");

        System.out.println(map.get(null));
    // final JSONObject obj = new JSONObject();
    }
}
