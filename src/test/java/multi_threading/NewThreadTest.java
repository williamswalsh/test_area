package multi_threading;

import org.junit.Test;

public class NewThreadTest {


    @Test
    public void newThreadTest() {
        Thread t = new Thread(() -> System.out.println("Hi"));
        t.start();
        System.out.println("Is thread alive: " + t.isAlive());
        System.out.println("Thread name: " + t.getName());
        t.interrupt();
    }
}
