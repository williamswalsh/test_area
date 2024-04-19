package pattern;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertNotEquals;

public class PatternTest {


    @Test
    public void patternEqualityTest() {
        String REGEX = ".*www.*";

        Pattern pattern1 = Pattern.compile(REGEX);
        Pattern pattern2 = Pattern.compile(REGEX);

        // Pattern uses the Object equals method
        // Referential equality
        // doesn't use "logical equality"
        // N.B.: where if 2 patterns have the same regex they are equivalent
        assertNotEquals(pattern1, pattern2);
    }
}
