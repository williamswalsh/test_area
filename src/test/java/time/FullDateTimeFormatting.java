package time;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FullDateTimeFormatting {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm O");

    private String join(String... values) {
        return Stream.of(values).filter(StringUtils::isNotBlank).collect(Collectors.joining(" "));
    }

    @Test
    public void printDataTime() {
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println(offsetDateTime.format(FORMATTER));
    }

    @Test
    public void testJoin() {
        System.out.println(join("<ORDER_ID>", "-", null, "William", "Walsh"));
    }
}
