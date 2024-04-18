package fibonnaci;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonaciFinderTest {
    static int getFib(int N)
    {
        int[] f= new int[N + 2];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= N; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[N];
    }

    @Test
    public void getFibTest() {
        assertEquals(0, getFib(0));
        assertEquals(1, getFib(1));
        assertEquals(2, getFib(3));
        assertEquals(3, getFib(4));
        assertEquals(5, getFib(5));
        assertEquals(8, getFib(6));
    }
}
