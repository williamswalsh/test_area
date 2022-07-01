package time;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class DateFormattingTest {

    @Test
    public void testAllValues() {
        DateFormatting df = new DateFormatting(LocalDate.now(), 7, 2022);
        System.out.println(df.getFormattedDateOfBirth());
    }

    @Test
    public void testNullDateOfBirth() {
        DateFormatting df = new DateFormatting(null, 7, 2022);
        System.out.println(df.getFormattedDateOfBirth());
    }

    @Test
    public void testNullDateOfBirthAndNullMonthOfBirth() {
        DateFormatting df = new DateFormatting(null, null, 2022);
        System.out.println(df.getFormattedDateOfBirth());
    }

    @Test
    public void testNullDateOfBirthAndNullYearOfBirth() {
        DateFormatting df = new DateFormatting(null, 7, null);
        System.out.println(df.getFormattedDateOfBirth());
    }

    @Test
    public void testAllNull() {
        DateFormatting df = new DateFormatting(null, null, null);
        assertEquals("-", df.getFormattedDateOfBirth());
    }
}
