package uuid;

import org.junit.Test;

import java.util.UUID;

public class UuidTest {

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
}
