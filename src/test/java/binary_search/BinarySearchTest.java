package binary_search;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BinarySearchTest {


    private final int fTarget;

    private final int fIndexOfTarget;

    public BinarySearchTest(int fTarget, int fIndexOfTarget) {
        this.fTarget = fTarget;
        this.fIndexOfTarget = fIndexOfTarget;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 5, 0 }, { 10, 1 }, { 15, 2 }, {20, 3 }, { 25, 4 }, { 30, 5 }, { 79, 12 }
        });
    }

    @Test
    public void searchTest() {
        List<Integer> ints = Arrays.asList(5, 10, 15, 20, 25, 30, 35, 40, 45, 49, 52, 60, 79);

        Optional<Integer> index = search(ints, fTarget);
        assertTrue(index.isPresent());
        int indexValue = index.get();
        assertEquals(fIndexOfTarget, indexValue);
    }

    public Optional<Integer> search(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int middle = (low + high)/2;
            int midValue = list.get(middle);

            if (midValue > target) {
                high = middle - 1;
            } else if (midValue < target) {
                low = middle + 1;
            } else {
                return Optional.of(middle);
            }
        }
        return Optional.empty();
    }
}
