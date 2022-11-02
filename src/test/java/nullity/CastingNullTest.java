package nullity;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertNull;

/**
 * @author William Walsh
 * @version 28 Oct 2022
 */
public class CastingNullTest {

    @Test
    public void castNullToType() {
        List<String> strings = (List<String>) null;
        assertNull(strings);
    }
}
