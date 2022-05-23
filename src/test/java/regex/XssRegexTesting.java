package regex;

import org.junit.Test;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class XssRegexTesting {

    public static final String NORMAL_FIELD_REGEX = "^[^\\\"\\<\\>\\&]+$";
    public static final String CUSTOM_FIELD_REGEX = "^[^\\\"\\<\\>]+$";

    @Test
    public void testNormalFieldRegexWithEmptyString() {
        validateAgainstRegex("", NORMAL_FIELD_REGEX);
    }

    @Test
    public void testNormalFieldRegexWithNullString() {
        validateAgainstRegex(null, NORMAL_FIELD_REGEX);
    }

    @Test(expected = RuntimeException.class)
    public void testNormalFieldRegexWithAmpersandInString() {
        validateAgainstRegex("&", NORMAL_FIELD_REGEX);
    }

    @Test
    public void testCustomFieldRegexWithEmptyString() {
        validateAgainstRegex("", CUSTOM_FIELD_REGEX);
    }

    @Test
    public void testCustomFieldWithNullString() {
        validateAgainstRegex(null, CUSTOM_FIELD_REGEX);
    }

    @Test
    public void testCustomFieldWithAmpersandInString() {
        validateAgainstRegex("&", CUSTOM_FIELD_REGEX);
    }


    private void validateAgainstRegex(final String value, final String regex) {
        if (isNotBlank(value) && !value.matches(regex)) {
            throw new RuntimeException("Wrong");
        }
    }

}
