package string_testing;

import org.junit.Test;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class IsBlankTest {
    @Test
    public void isBlankWithString() {
        isBlank("not_blank");
    }

    @Test
    public void isBlankWithInteger() {
        Object ref = new Integer(7);
        // isBlank(ref); // Compile time error
    }

    @Test
    public void isBlankWithCode() throws Exception {
        Object value = stringGenerator("hey");
        if (( isBlank((String) value)) || value == null) {
            throw new Exception("bad");
        }
    }

    private String stringGenerator(String s) {
        return s;
    }
}