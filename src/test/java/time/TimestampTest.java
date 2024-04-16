package time;

import org.junit.Test;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampTest {

    @Test
    public void getTime() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
    }

    @Test
    public void getNanoTime() {
        Timestamp timestamp = new Timestamp(System.nanoTime());
        System.out.println(timestamp);
    }

    @Test
    public void name() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowFormatted = now.format(dtf);
        System.out.println(nowFormatted);
        LocalDateTime after = LocalDateTime.now();
    }
}
