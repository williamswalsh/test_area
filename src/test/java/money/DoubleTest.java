package money;

import org.junit.Test;

public class DoubleTest {

    @Test
    public void testTaxAsDouble() {
        String quadernoTax = "2.3333333333";
        int netPrice = 1000;
        int PERCENT = 100;

        System.out.println((int) Math.round(Double.parseDouble(quadernoTax) * netPrice / PERCENT));
    }
}
