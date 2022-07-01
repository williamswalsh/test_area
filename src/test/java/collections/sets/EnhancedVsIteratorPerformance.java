package collections.sets;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

public class EnhancedVsIteratorPerformance {

    private static Set<UUID> uuids;

    @BeforeClass
    public static void fillSet() {
        uuids = new HashSet<>();

        for(int i = 0; i < 100; i++) {
            uuids.add(UUID.randomUUID());
        }
    }

    public void getEachElementInSetUsingIterator() {
        Iterator<UUID> i = uuids.iterator();
        while(i.hasNext()) {
            System.out.println(i.next());
        }
    }

    public void getEachElementInSetUsingEnhancedFor() {
        for (UUID uuid: uuids) {
            System.out.println(uuid);
        }
    }

    /**
     * This method takes a method reference to measure the time taken by that method to execute.
     *
     * @param method
     * @return
     */
    private static long getDuration(Runnable method) {
        long startTime = System.nanoTime();
        method.run();
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

    @Test
    public void comparison() {
        int repetitions = 10;
        for (int i = 0; i < repetitions; i++) {
            long iteratorTimeInNanos = getDuration(this::getEachElementInSetUsingIterator);
            long enhancedForTimeInNanos = getDuration(this::getEachElementInSetUsingEnhancedFor);

            System.out.println("iteratorTimeInNanos:    " + iteratorTimeInNanos);
            System.out.println("enhancedForTimeInNanos: " + enhancedForTimeInNanos);
        }
    }
}

// 10 repetitions of 100 UUIDs
// iteratorTimeInNanos:    4148270
// enhancedForTimeInNanos: 3363076
// iteratorTimeInNanos:    2992820
// enhancedForTimeInNanos: 4228883
// iteratorTimeInNanos:    3598079
// enhancedForTimeInNanos: 3988540
// iteratorTimeInNanos:    3598079
// enhancedForTimeInNanos: 3988540
// iteratorTimeInNanos:    2683354
// enhancedForTimeInNanos: 1744291
// iteratorTimeInNanos:    2683354
// enhancedForTimeInNanos: 1744291




// 100
// iteratorTimeInNanos:    4161424
// enhancedForTimeInNanos: 4342327
// 1000
// iteratorTimeInNanos:    70209354
// enhancedForTimeInNanos: 16145537
// 10000 - wo debug
// iteratorTimeInNanos:   124534335
// enhancedForTimeInNanos: 85982652
// 10000 - w debug
// iteratorTimeInNanos:   162787384
// enhancedForTimeInNanos: 92794375
// 100000
// iteratorTimeInNanos:    670403216
// enhancedForTimeInNanos: 463527248
// 1000000
// iteratorTimeInNanos:    4003052695
// enhancedForTimeInNanos: 4187059735