import org.junit.Test;

import java.time.LocalDate;

public class LocalDateTest {

    @Test
    public void printLocalDateFormatTest() {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate: " + localDate);
    }
}