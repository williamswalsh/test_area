package printStackTraceTest;

import org.junit.Test;

public class PrintStackTraceTest {

    /**
     * This test shows that printStackTrace doesn't stop program execution.
     * It merely prints out the exception stack trace
     */
    @Test
    public void printStackTraceTest() {
        try {
            throw new Exception("oops");
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("after e.printStackTrace()");
        }
        System.out.println("after try-catch blocks");
    }
}
