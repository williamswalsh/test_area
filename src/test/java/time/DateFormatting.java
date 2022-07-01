package time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM/yyyy");
    private static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("MM");
    public static final String NO_VALUE = "-";

    private final LocalDate dateOfBirth;
    private final Integer monthOfBirth;
    private final Integer yearOfBirth;

    public DateFormatting(LocalDate dateOfBirth, Integer monthOfBirth, Integer yearOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public String getFormattedDateOfBirth() {
        if (dateOfBirth != null) {
            return dateOfBirth.format(FORMATTER);
        }
        if (monthOfBirth != null && yearOfBirth != null) {
            return LocalDate.of(yearOfBirth, monthOfBirth, 1).format(FORMATTER);
        }
        if (yearOfBirth != null) {
            return yearOfBirth.toString();
        }
        if (monthOfBirth != null) {
            return LocalDate.of(0, monthOfBirth, 1).format(MONTH_FORMATTER);
        }
        return NO_VALUE;
    }
}
