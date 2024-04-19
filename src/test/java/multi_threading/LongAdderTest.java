package multi_threading;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class LongAdderTest {

    @Test
    public void longAdderTest() {
        LongAdder counter = new LongAdder();
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        int numberOfThreads = 4;
        int numberOfIncrements = 100;

        Runnable incrementAction = () -> IntStream
                .range(0, numberOfIncrements)
                .forEach(i -> {
                    counter.increment();
//                    System.out.println(counter); // 0-214
//                    This is incrementing the value of counter?
                });

        System.out.println(counter);


        for (int i = 0; i < numberOfThreads; i++) {
            executorService.execute(incrementAction);
        }

        System.out.println(counter);

//        NOT EQUALS?????
        assertEquals(numberOfIncrements * numberOfThreads, counter.sumThenReset());
//        assertEquals(counter.sum(), 0);
    }


    @Test
    public void longAccumulatorTest() {

        LongAccumulator accumulator = new LongAccumulator(Long::sum, 0L);
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        int numberOfThreads = 4;
        int numberOfIncrements = 100;

        Runnable accumulateAction = () -> IntStream
                .rangeClosed(0, numberOfIncrements)
                .forEach(accumulator::accumulate);

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.execute(accumulateAction);
        }
        assertEquals(accumulator.get(), 20200);
    }

    @Test
    public void stackOverflowAdderTest() throws InterruptedException {
        LongAdder adder = new LongAdder();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        ConcurrentHashMap<Long, Integer> count = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++)
        {
            executor.execute(() -> {
                for (int j = 0; j < 1000000; j++)
                {
                    adder.add(1);
                    count.merge(adder.longValue(), 1, Integer::sum);
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
        count.entrySet().stream().filter(e -> e.getValue() > 1).forEach(System.out::println);
    }

    // 13ms-18ms - faster??
    @Test
    public void concurrentHashMapTest() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Adding elements to the map
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        System.out.println("Map size: " + map.size());

        // Getting values from the map
        int valueA = map.get("A");
        System.out.println("Value of A: " + valueA);

        // Removing elements from the map
        map.remove("B");
        System.out.println("Map size: " + map.size());
    }

    // 13ms-19ms
    @Test
    public void hashMapTest() {
        HashMap<String, Integer> map = new HashMap<>();

        // Adding elements to the map
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        System.out.println("Map size: " + map.size());

        // Getting values from the map
        int valueA = map.get("A");
        System.out.println("Value of A: " + valueA);

        // Removing elements from the map
        map.remove("B");
        System.out.println("Map size: " + map.size());
    }
}
