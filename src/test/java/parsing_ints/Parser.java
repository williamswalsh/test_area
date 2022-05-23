package parsing_ints;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import org.junit.Test;

public class Parser {

    @Test(expected = NumberFormatException.class)
    public void testParseIntNullInput() {
        String shareCredits = null;
        int i = Integer.parseInt(shareCredits);
    }

    @Test(expected = NumberFormatException.class)
    public void testParseIntBlankInput() {
        String shareCredits = " ";
        int i = Integer.parseInt(shareCredits);
    }

    @Test(expected = NumberFormatException.class)
    public void testParseIntNonBlankInput() {
        String shareCredits = "d";
        int i = Integer.parseInt(shareCredits);
    }

    @Test
    public void b() {
        String shareCredits = null;
        if (isNotBlank(shareCredits) && Integer.parseInt(shareCredits) > 0) {
            System.out.println("Hello");
        }
    }

    @Test
    public void a() {
        String shareCredits = null;
        if (shareCredits != null && Integer.parseInt(shareCredits) > 0) {
            System.out.println("Hello");
        }
    }

}


// null                  -> null  NumberFormatException
// blank                 -> " "   NumberFormatException
// Nonblank + NAN        -> "d"   NumberFormatException
// An integer            ->  7    NumberFormatException
