package uuid;

import org.junit.Test;

import java.util.UUID;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertTrue;

public class UuidTest {
    private static final String UUID_PATTERN = "[0-9a-zA-Z]{8}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{12}";
    @Test
    public void uuidBlank() throws Exception {
        UUID uuid = null;
        UUID uuid2 = UUID.randomUUID();

        if(uuid2 == null) {
            throw new Exception("isNull - testing exception");
        }

        if(uuid2.equals("")) {
            throw new Exception("isBlank - testing exception");
        }
    }

    @Test
    public void checkUuidAgainstPattern() {
        UUID productId = UUID.randomUUID();
        assertTrue(Pattern.matches(UUID_PATTERN, productId.toString()));
    }
}
