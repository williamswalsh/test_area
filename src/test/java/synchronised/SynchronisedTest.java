package synchronised;

import org.junit.Test;

public class SynchronisedTest {

    @Test
    public void synchronisedBlock() {



        Object lock = new Object();



        // lock here is called "the monitor object".
        synchronized (lock) {
            // Synchronized code block
            // Only one thread can execute this block at a time
            // lock.somethingOnlyOneThreadCanDo().
        }
    }


}

class Counter {
    private int count = 0;
    private final Object lock = new Object();

    public void increment() {
        synchronized (lock) {
            count++;
        }
    }

    public int getCount() {
        synchronized (lock) {
            return count;
        }
    }
}
class CounterSyncMethod {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}