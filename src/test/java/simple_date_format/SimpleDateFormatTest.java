package simple_date_format;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    private static final String TIMESTAMP_FORMAT_WITH_K = "yyyyMMddkkmmss";
    private static final String TIMESTAMP_FORMAT_WITH_H = "yyyyMMddHHmmss";

    @Test
    public void testSimpleDate() {
        System.out.println(new SimpleDateFormat(TIMESTAMP_FORMAT_WITH_K).format(new Date()));
    }
    @Test
    public void testSimpleDate2() {
        System.out.println(new SimpleDateFormat(TIMESTAMP_FORMAT_WITH_H).format(new Date()));
    }
}
