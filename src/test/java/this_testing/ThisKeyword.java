package this_testing;

import org.junit.Test;

public class ThisKeyword {


    String carMake;

    public ThisKeyword(String carMakeParam) {
        carMake = carMakeParam;
    }


    @Test
    public void testKeyword() {
        ThisKeyword thisKeyword = new ThisKeyword("toyota");
    }
}
