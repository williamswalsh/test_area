package math_testing;

import org.junit.Test;

public class MathTest {

    @Test
    public void testRoundMethod() {
        double a = 1.5;
        double b = 1.4;
        double c = 1.6;

        System.out.println(Math.round(a));
        System.out.println(Math.round(b));
        System.out.println(Math.round(c));
    }
}
