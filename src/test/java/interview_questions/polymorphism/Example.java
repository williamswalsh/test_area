package interview_questions.polymorphism;

import org.junit.Test;

/**
 * @author William Walsh
 * @version 15 Oct 2022
 */
public class Example {

    @Test
    public void testPolymorphism() {
        // More generic reference can point to more specific type
        Bird b = new Bird();
        Bird c = new Crow();
        Bird r = new Robin();

        // behaviour depends on type which reference is pointing to
        b.call();
        c.call();
        r.call();

        // Crow is a Bird
        // Bird is not a Crow - Bird is not a type of Crow
        // Crow crow = new Bird();
    }
}

class Bird {
    void call() {
        System.out.println("Generic Bird call");
    }
}
class Crow extends Bird{

    @Override
    void call() {
        System.out.println("Cawww");
    }
}
class Robin extends Bird{

    @Override
    void call() {
        System.out.println("Tweet");
    }
}

