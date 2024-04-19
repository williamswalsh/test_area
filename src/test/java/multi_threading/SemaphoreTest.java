package multi_threading;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.Semaphore;

import static org.junit.Assert.*;

public class SemaphoreTest {

    @Test
    public void semPermitsTest() {
        Semaphore s = new Semaphore(1);
        assertEquals(1, s.availablePermits());
    }

    @Test
    public void semPermitsAcquireTest() throws InterruptedException {
        Semaphore s = new Semaphore(1);
        s.acquire();
        assertEquals(0, s.availablePermits());
        s.release();
        assertEquals(1, s.availablePermits());
    }

    @Ignore
    @Test
    public void semPermitsAcquireBlocksTest() throws InterruptedException {
        Semaphore s = new Semaphore(3); // 3 semaphores
        s.acquire(3); // use 3 permits
        s.acquire(); // try to use another - will hang on this statement
    }

    @Test
    public void semaphoreTryAcquire() throws InterruptedException {
        Semaphore s = new Semaphore(1);
        assertTrue(s.tryAcquire()); // Try to get permit - get one if available
        assertEquals(0, s.availablePermits()); // No permits left
    }
}
