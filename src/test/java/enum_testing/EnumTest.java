package enum_testing;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.*;

public class EnumTest {

    @Test
    public void enumValueOf() {
        OrderStatus example = OrderStatus.valueOf("IN_PROGRESS");
        assertEquals(OrderStatus.IN_PROGRESS, example);
        assertNotEquals(OrderStatus.CREATED, example);
    }
    enum OrderStatus{ CREATED, IN_PROGRESS, COMPLETED}
    enum PaymentStatus {
        CREATED("created"),
        IN_PROGRESS("inprogress"),
        COMPLETED("completed");

        PaymentStatus(String value) {
            this.value = value;
        }

        private final String value;

        private String getValue() {
            return value;
        }

        public static PaymentStatus fromString(final String value) {
            return Stream.of(PaymentStatus.values())
                    .filter(status -> status.getValue().equalsIgnoreCase(value))
                    .findAny().orElse(null);
        }
    }
}
