package lambda_throws_runtime;

import org.junit.Test;

import java.security.InvalidParameterException;
import java.util.stream.Stream;

/**
 * @author William Walsh
 * @version 02 Nov 2022
 */
public class Testing {

    @Test(expected = InvalidParameterException.class)
    public void testLambdaThrowingException() {

        Stream.of(1, 2, 3, 4, 5, 6)
                .forEach(this::throwsException);
    }

    /**
     * Processing will halt at the integer which matching the criteria (3).
     */
    private void throwsException(Integer integer) {
        System.out.println("Integer: " + integer);
        if (integer % 3 == 0) {
            throw new InvalidParameterException("Number is divisible by three.");
        }
    }
}
