package parallelism;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExecutorServiceFixtureTest {

    private static ExecutorService executor;

    @BeforeAll
    public static void setUp() {
        executor = Executors.newSingleThreadExecutor();
    }

    @AfterAll
    public static void tearDown() {
        executor.shutdown();
    }

    @Test
    public void concatResultsFromMultipleTasks() throws ExecutionException, InterruptedException {
        Callable<String> taskA = () -> {
            Thread.sleep(1000);
            return "VERY_VALUABLE";
        };

        Callable<String> taskB = () -> {
            Thread.sleep(500);
            return "_DATA_RESULT";
        };


        Future<String> futureResultA = executor.submit(taskA);
        Future<String> futureResultB = executor.submit(taskB);
        String resultA, resultB = "";

        resultA = futureResultA.get();
        resultB = futureResultB.get();

        assertEquals("VERY_VALUABLE_DATA_RESULT", resultA + resultB);
    }


    // This test takes 21.5 seconds using a single thread
    // with string buffer having to resize
    @Test
    public void overloadSingleThreadExecutor() throws ExecutionException, InterruptedException {
        final int numOfTasks = 100000000;
        final String data = "A";
        Callable<String> task = () -> data;
        ArrayList<Future<String>> futureResults = new ArrayList<>(numOfTasks);

        for (int taskNumber = 0; taskNumber < numOfTasks; taskNumber++) {
            Future<String> futureResult = executor.submit(task);
            futureResults.add(futureResult);
        }

        StringBuffer combinedResults = new StringBuffer(numOfTasks);

//        Wait for all results - starting with the first then second, etc
        for (Future<String> result: futureResults) {
            combinedResults.append(result.get());
        }

        final String expected = "A".repeat(numOfTasks);
        assertEquals(expected, combinedResults.toString());
    }


    // This test takes 13 seconds using a single thread
    // with string buffer not having to resize - initial capacity is set to required amount.
    @Test
    public void seeHowMuchResizingStringBufferAffectsTestDuration() throws ExecutionException, InterruptedException {
        final int numOfTasks = 100000000;
        final String data = "A";
        Callable<String> task = () -> data;
        ArrayList<Future<String>> futureResults = new ArrayList<>(numOfTasks);

        for (int taskNumber = 0; taskNumber < numOfTasks; taskNumber++) {
            Future<String> futureResult = executor.submit(task);
            futureResults.add(futureResult);
        }

        StringBuffer combinedResults = new StringBuffer(numOfTasks);

//        Wait for all results - starting with the first then second, etc
        for (Future<String> result: futureResults) {
            combinedResults.append(result.get());
        }

        final String expected = "A".repeat(numOfTasks);
        assertEquals(expected, combinedResults.toString());
    }
}
