package bigdecimal;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author William Walsh
 * @version 26 Oct 2022
 */
public class BigDecimalTest {

    @Test
    public void createBigDecimalNullInput() {
        String str = "8.0";
        if (true){
            str = null;
        }
        BigDecimal bigDecimal = new BigDecimal(str);
    }
}
