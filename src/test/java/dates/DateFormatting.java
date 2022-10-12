package dates;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author William Walsh
 * @version 12 Oct 2022
 */
public class DateFormatting {

    @Test
    public void test() throws ParseException {
        assertEquals("Wed Nov 15 00:00:00 GMT 2017",
                new SimpleDateFormat("yyyy-MM-dd")
                        .parse("2017-11-15")
                        .toString());
        assertEquals("Thu Jan 01 15:30:14 IST 1970",
                new SimpleDateFormat("HH:mm:ss")
                        .parse("15:30:14")
                        .toString());
        assertEquals("Wed Nov 15 15:30:14 GMT 2017",
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                        .parse("2017-11-15 15:30:14.332")
                        .toString());
    }
}
