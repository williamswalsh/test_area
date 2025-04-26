package parallelism;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VectorTest {

    @Test
    void addElementToVectorTest() {
        Vector<Integer> ints = new Vector<>();
        ints.addElement(4);
        ints.addElement(4);
        ints.addElement(4);
        assertEquals(3, ints.size());
        System.out.println(ints);
    }

//    Arraylist is not threadsafe - asserting size test fails
//    vector is synchronised
    @Test
    void checkArrayListSizeIncreaseTest() throws InterruptedException {
        int totalNumOfTasks = 100000;
        ArrayList<Integer> ints = new ArrayList<>();

        Runnable increaseSizeTask = () -> ints.add(1);
        ExecutorService e = Executors.newFixedThreadPool(10);

        for (int tasks = 0; tasks < totalNumOfTasks; tasks++) {
            e.execute(increaseSizeTask);
        }

//    Necessary to shut down executor service and wait for the tasks to complete
        e.shutdown();
        e.awaitTermination(10, TimeUnit.SECONDS);

        int expectedSize = totalNumOfTasks;
//    This test fails as the final size is nothing like the expected size totalNumOfTasks
//    Expected :100000
//    Actual   :99936 -> off by 64 in this case
        assertEquals(expectedSize, ints.size());
    }

//    vector is threadsafe in some cases - asserting size test succeeds
    @Test
    void checkVectorSizeIncreaseTest() throws InterruptedException {
        int totalNumOfTasks = 100000;

//        Only change is data structure ArrayList -> Vector
        Vector<Integer> ints = new Vector<>();

        Runnable increaseSizeTask = () -> ints.add(1);
        ExecutorService e = Executors.newFixedThreadPool(10);

        for (int tasks = 0; tasks < totalNumOfTasks; tasks++) {
            e.execute(increaseSizeTask);
        }

//    Necessary to shut down executor service and wait for the tasks to complete
        e.shutdown();
        e.awaitTermination(10, TimeUnit.SECONDS);

        int expectedSize = totalNumOfTasks;
//    This test always succeeds, Cool :-)
//    Expected :100000
//    Actual   :100000
        assertEquals(expectedSize, ints.size());
    }

    @Test
    void test() throws InterruptedException {
        int totalNumOfTasks = 20;
        Vector<Integer> v = new Vector<>();

        Runnable printSizeTask = () -> System.out.println("Vector Size: " + v.size());
        Runnable increaseSizeTask = () -> v.addElement(1);
        ExecutorService e = Executors.newFixedThreadPool(2);

        for (int tasks = 0; tasks < totalNumOfTasks; tasks++) {
            e.submit(printSizeTask);
            e.execute(increaseSizeTask);
        }
        int expectedSize = 20;

        // Necessary to shut down executor service and wait for the tasks to complete
        e.shutdown();
        e.awaitTermination(10, TimeUnit.SECONDS);

        assertEquals(expectedSize, v.size());
    }


    @Test
    void usingLatchToWaitForTaskCompletionTest() throws InterruptedException {
        int totalNumOfTasks = 20;
        Vector<Integer> v = new Vector<>();
        CountDownLatch latch = new CountDownLatch(totalNumOfTasks);

        Runnable printSizeTask = () -> {
            System.out.println("Vector Size: " + v.size());
            latch.countDown();
        };
        Runnable increaseSizeTask = () -> {
            v.addElement(1);
            latch.countDown();
        };
        ExecutorService e = Executors.newFixedThreadPool(2);

        for (int tasks = 0; tasks < totalNumOfTasks; tasks++) {
            if (tasks % 2 == 0) {
                e.submit(printSizeTask);
            } else {
                e.execute(increaseSizeTask);
            }
        }
        int expectedSize = 10;

//        Wait for all tasks to have completed. :-)
        latch.await();

//        Vector is complete after latch is opened(zero-value)
        System.out.println("Vector: " + v);

        assertEquals(expectedSize, v.size());
    }
}
