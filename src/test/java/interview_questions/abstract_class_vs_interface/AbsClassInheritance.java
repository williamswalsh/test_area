package interview_questions.abstract_class_vs_interface;

/**
 * @author William Walsh
 * @version 14 Oct 2022
 */
public class AbsClassInheritance {
}

abstract class A {
    abstract void abstractMethod();
}

class Concrete extends A {
    @Override
    void abstractMethod() {
        System.out.println("Must implement all abstract methods from A, otherwise must be abstract");
    }
}

// no need to implement methods as class is abstract
abstract class AbstractClass extends A {}

// Can only inherit single class - class cannot extend multiple classes

class ConcreteClassSample {
    int concreteMethod() {
        return 0;
    }
}

abstract class AbstractClassExtendingConcreteClass extends ConcreteClassSample {
    abstract int getNumberAbstract();
}
class ConcreteClass extends AbstractClassExtendingConcreteClass {

    @Override
    int getNumberAbstract() {
        return concreteMethod();
    }
}