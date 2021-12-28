import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class StripTest {

    @Test
    public void given_string_has_newline_when_strip_is_called_then_newline_removed() {
        String strWithNewline = "William\n";
        String strWithoutNewline = strWithNewline.strip();
        assertFalse(strWithoutNewline.contains("\n"));
    }

    @Test
    public void given_string_has_carraige_return_when_strip_is_called_then_carraige_return_removed() {
        String strWithNewline = "William\r";
        String strWithoutNewline = strWithNewline.strip();
        assertFalse(strWithoutNewline.contains("\r"));
    }
}
