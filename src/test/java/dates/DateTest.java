package dates;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTest {

    @Test
    public void dateConstructorTest() {
        System.out.println(new Date());
    }

    @Test
    public void localDateTimeConstruction1() {
        System.out.println(LocalDateTime.now());
    }

    @Test
    public void localDateTimeConstruction() {
        LocalDateTime now = LocalDateTime.now();

        System.out.println("Before : " + now);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

        String formatDateTime = now.format(formatter);

        System.out.println("After : " + formatDateTime);
    }
}
