package interview_questions.abstract_class_vs_interface;

/**
 * @author William Walsh
 * @version 15 Oct 2022
 */
public class AbsClassClassInheritance extends MyAbstractClass {
    @Override
    public void printMsg() {
        System.out.println("Im a concrete method inside a concrete class");
    }
}

abstract class MyAbstractClass {
    public abstract void printMsg();
}

// Abstract class can exist without an abstract method
// useless but can happen
abstract class MyAbstractClassWithoutAnyAbstractMethod {}