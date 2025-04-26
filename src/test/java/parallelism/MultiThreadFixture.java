package parallelism;

import org.junit.Test;

import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

public class MultiThreadFixture {

    @Test
    public void getIdOfCurrentThreadTest() {
        Thread currentThread = Thread.currentThread();
        assertEquals(1, currentThread.getId());
        assertEquals("main", currentThread.getName());
    }

    @Test
    public void getNameOfCurrentThreadTest() {
        Thread currentThread = Thread.currentThread();
        assertEquals("main", currentThread.getName());
    }

    @Test
    public void thisWontPrintAnything_canYouTellMeWhy_test() {
        Runnable r = () -> {
            long threadId = Thread.currentThread().getId();
            System.out.println("I am a thread, my ID is: " + threadId);
        };
        Thread t = new Thread(r);
        t.start();
    }

    @Test
    public void printIdOfThread() throws InterruptedException {
        Runnable r = () -> {
            long threadId = Thread.currentThread().getId();
            System.out.println("I am a thread, my ID is: " + threadId);
        };
        Thread t = new Thread(r);
        t.start();
        t.join(); // <- wait for the thread to finish
    }

    @Test
    public void thisTestWillRunForMoreThanFiveSeconds() throws InterruptedException {
        Runnable longRunningTask = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread t = new Thread(longRunningTask);
        t.start();
        t.join();
    }

    @Test
    public void thisExecutorWillReturnAValueAndTheTestThreadWillPrintIt() throws ExecutionException, InterruptedException {
        Callable<String> longRunningTask = () -> {
            Thread.sleep(1000);
            return "VERY_VALUABLE_DATA_RESULT";
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> futureResult = executor.submit(longRunningTask);
        String result = "";

        result = futureResult.get();
        executor.shutdown();

        assertEquals("VERY_VALUABLE_DATA_RESULT", result);
    }

    @Test
    public void concatResultsFromMultipleTasks() throws ExecutionException, InterruptedException {
        Callable<String> taskA = () -> {
            Thread.sleep(2000);
            return "VERY_VALUABLE";
        };

        Callable<String> taskB = () -> {
            Thread.sleep(1000);
            return "_DATA_RESULT";
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> futureResultA = executor.submit(taskA);
        Future<String> futureResultB = executor.submit(taskB);
        String resultA, resultB = "";

        resultA = futureResultA.get();
        resultB = futureResultB.get();
        executor.shutdown();

        assertEquals("VERY_VALUABLE_DATA_RESULT", resultA + resultB);
    }
}
