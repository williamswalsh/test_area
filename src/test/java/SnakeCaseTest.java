import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SnakeCaseTest {

    private String camelCaseToSnakeCase(String value) {
        String regex = "([a-z])([A-Z])";
        String replacement = "$1_$2";
        return value.replaceAll(regex, replacement).toLowerCase();
    }

    @Test
    public void convert() {
        assertEquals("order_status", camelCaseToSnakeCase("OrderStatus"));
    }
}
