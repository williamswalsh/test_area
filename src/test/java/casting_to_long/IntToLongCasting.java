package casting_to_long;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author William Walsh
 * @version 04 Jan 2023
 */
public class IntToLongCasting {


    @Test
    public void testCastingPurpose() {
        int intA = 20;
        int intB = 30;

        int result = intA - intB;
        System.out.println(result);

        long resultLong = (long) intA - intB;
        System.out.println(resultLong);

    //    Casting used to cast explicitly for methods: Streams.skip(long n), .limit(long n)
    }
}
