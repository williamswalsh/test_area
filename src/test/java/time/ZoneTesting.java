package time;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;

public class ZoneTesting {

    @Test
    public void retrieveDefaultZoneId() {
        System.out.println(ZoneId.systemDefault());
    }

    @Test
    public void retrieveOffsetDateTimeFromEpoch() {
        System.out.println(OffsetDateTime.ofInstant(Instant.ofEpochSecond(1546792089L), ZoneId.systemDefault()));
    }
}
