package string_testing;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class StringSplitTest {

    @Test
    public void splitStringTest() {
        String s1 = "Java,Selenium,TestNG,Karate,SQL";
        String[] strings = s1.split(",");

        for (int i=1; i<=strings.length; i++) {
            System.out.println("String " + i + ": " + strings[i-1]);
        }
    }

    @Test
    public void testComparison() {
        assertEquals(1, new Version("1.1.1.0").compareTo(new Version("1.1.1")));
        assertEquals(0, new Version("1.1.1.0").compareTo(new Version("1.1.1.0")));
        assertEquals(1, new Version("1.1.1.1").compareTo(new Version("1.1.1.0")));
        assertEquals(-1, new Version("1.1.1.0").compareTo(new Version("1.1.1.1")));

        assertEquals(-1, new Version("2.1.1").compareTo(new Version("2.1.2")));
        assertEquals(1, new Version("2.1.2").compareTo(new Version("2.1.1")));
        assertEquals(0, new Version("2.1.1").compareTo(new Version("2.1.1")));
        assertEquals(-1, new Version("2.1.1").compareTo(new Version("2.1.2.0")));

        assertEquals(1, new Version("2.1.2.0").compareTo(new Version("2.1.1")));
        assertEquals(-1, new Version("2.1.1").compareTo(new Version("2.1.1.0")));
        assertEquals(-1, new Version("2.1.0.0").compareTo(new Version("2.1.1")));

        assertEquals(0, new Version("1.1.1").compareTo(new Version("1.1.1")));
        assertEquals(1, new Version("1.1.1").compareTo(new Version("1.1.0")));
        assertEquals(-1, new Version("1.1.0").compareTo(new Version("1.1.1")));
    }

    @Test
    public void getComponentsFrom3PartVersion() {
        Version v = new Version("2.1.1");
        assertEquals(2, v.getMajor());
        assertEquals(1, v.getMinor());
        assertEquals(1, v.getPatch());
        assertTrue(v.isThreeDigit());
        assertEquals(0, v.getSubPatch());
    }

    @Test
    public void getComponentsFrom4PartVersion() {
        Version v = new Version("2.1.1.3");
        assertEquals(2, v.getMajor());
        assertEquals(1, v.getMinor());
        assertEquals(1, v.getPatch());
        assertFalse(v.isThreeDigit());
        assertEquals(3, v.getSubPatch());
    }


    // tets langToManualMap

    @Test
    public void getLatestManualMap() {
        List<String> resources = new DummyS3Service().getResourceList();
        List<ManualResource> resourceFiles = resources
                .stream()
                .map(ManualResource::new)
                .collect(Collectors.toList());

        Map<String, ManualResource> langToManualMap = new HashMap<>();

        for(ManualResource resource: resourceFiles) {

            if(langToManualMap.containsKey(resource.getLanguage())) {
                Version currentMaxVersion = langToManualMap.get(resource.getLanguage()).getVersion();
                Version newVersion = resource.getVersion();

                if(currentMaxVersion.compareTo(newVersion) == -1) {
                    langToManualMap.put(resource.getLanguage(), resource);
                }
            } else {
                langToManualMap.put(resource.getLanguage(), resource);
            }
        }

        for (String name: langToManualMap.keySet()) {
            String key = name;
            ManualResource value = langToManualMap.get(name);
            System.out.println(key + ": " + value.getLanguage() + ", " + value.getVersion().getString() + ", " + value.getResourcePath());
        }
    }
}
