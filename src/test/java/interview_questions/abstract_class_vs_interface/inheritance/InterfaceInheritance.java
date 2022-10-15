package interview_questions.abstract_class_vs_interface.inheritance;

/**
 * @author William Walsh
 * @version 15 Oct 2022
 */
public class InterfaceInheritance {



}

interface A {
    public static final int intFromA = 5;
    public int intFromA();
}
interface B {
    public static final int intFromB = 7;
    public int intFromB();
}
interface C extends A,B {}

class ClassA implements C {

    @Override
    public int intFromA() {
        return 0;
    }

    @Override
    public int intFromB() {
        return 0;
    }
}