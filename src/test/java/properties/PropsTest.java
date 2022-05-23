package properties;

import org.junit.Test;

import java.util.Properties;

public class PropsTest {

    @Test
    public void setCeremonyNumberToNull() {
        Properties properties = new Properties();
        String ceremonyNumber = null;
        properties.put("ceremony_number", "");
        //properties.get("ceremony_number");
    }
}
