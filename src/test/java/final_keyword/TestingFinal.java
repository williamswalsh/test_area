package final_keyword;

import org.junit.Test;

/**
 * @author William Walsh
 * @version 06 Oct 2022
 */
public class TestingFinal {

    @Test
    public void testFinalMethodVariable() {
        final int i;
        System.out.println("Unrelated code execution");
        i=7;
        System.out.println(i);
    }
}
