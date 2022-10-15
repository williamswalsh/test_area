package interview_questions.abstract_class_vs_interface;

/**
 * @author William Walsh
 * @version 15 Oct 2022
 */

// Supports multiple interface implementation
public class InterfaceInheritance implements C, D {
    @Override
    public int getNumberInterfaceC() {
        return 0;
    }

    @Override
    public int getNumber() {
        return 0;
    }
}

interface C {
    int getNumberInterfaceC();
}
interface D {
    final static int iD = 0;
    int getNumber();
}

interface E extends D, C {
    final static int iE = 0;
    int getNumberChildInterface();
}

interface F {
    // public abstract is the default - implicit
    public abstract int method();
    int sameMethod();

    default int defaultMethod() {
        System.out.println("Default method in interface with default implementation");
        return 0;
    }

    static int staticMethod() {
        System.out.println("Static method in interface.");
        return 0;
    }
}

interface AccessModifiersMethods {

    // Abstract methods
    int publicNonStaticMethod();
    // protected int protectedNonStaticMethod();
    // private int privateNonStaticMethod();


    // Non-abstract methods -> static method
    // public by default
    static void publicStaticMethod() {
        System.out.println("publicStaticMethod");
    }
    private static void privateStaticMethod() {
        System.out.println("privateStaticMethod");
    }
    // protected not allowed with static
    // protected static void protectedStaticMethod() {
    //     System.out.println("protectedStaticMethod");
    // }

    // Non-abstract methods -> default methods
    // implicitly public
    public default void publicDefaultMethod() {
        System.out.println("publicDefaultMethod");
    }

    // Not sure why you can't have protected default?? - can override method in implementing class which is in same package?
    // protected default void protectedDefaultMethod() {
    //     System.out.println("protectedDefaultMethod");
    // }

    // This ends up being public due to the implicit interface behaviour of making a method public
    default void packageDefaultMethod() {
        System.out.println("packageDefaultMethod");
    }
    // illegal combination - default methods cannot be private or protected
    // private method won't be able to be overridden - so private default methods are a paradox.
    // private default void privateDefaultMethod() {
    //     System.out.println("privateDefaultMethod");
    // }
}

// No all variables in interface are public, static & final.
interface AreNonStaticVariablesAllowed {
    public final static int i = 9;
}
