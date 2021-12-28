import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CurrentYearBug {
    public static void main(String[] args) {
        String s = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

        final Map<String, Object> params = new HashMap<>();
        params.put("currentYear", String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));

        System.out.println(params);
    }
}
