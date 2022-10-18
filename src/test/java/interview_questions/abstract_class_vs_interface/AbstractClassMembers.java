package interview_questions.abstract_class_vs_interface;

/**
 * @author William Walsh
 * @version 14 Oct 2022
 */
public abstract class AbstractClassMembers {

    // Variables
    public int publicVar;
    protected int protectedVar;
    int packageVar;
    private int privateVar;

    // Static vars
    public static int publicStaticVar = 0;
    protected static int protectedStaticVar = 0;
    static int packageStaticVar = 0;
    private static int privateStaticVar = 0;

    // Concrete Methods
    public void publicConcreteMethod() {
        System.out.println("public non-static concrete method inside abstract class");
    }
    protected void protectedMethod() {
        System.out.println("protected non-static concrete method inside abstract class");
    }
    void packageConcreteMethod() {
        System.out.println("package non-static concrete method inside abstract class");
    }
    private void privateConcreteMethod() {
        System.out.println("private concrete method inside abstract class");
    }

    // Concrete static methods
    public final static void publicStaticConcreteMethod() {
        System.out.println("public static concrete method inside abstract class");
    }
    protected final static void protectedStaticConcreteMethod() {
        System.out.println("protected static concrete method inside abstract class");
    }
    final static void packageStaticConcreteMethod() {
        System.out.println("package static concrete method inside abstract class");
    }
    private final static void privateStaticConcreteMethod() {
        System.out.println("private static concrete method inside abstract class");
    }

    // Abstract Methods
    public abstract void publicAbstractMethod();
    protected abstract void protectedAbstractMethod();
    abstract void packageAbstractMethod();

    // private abstract void privateAbstractMethod();
    // NB: Illegal combination of modifiers: 'abstract' and 'private
    // Cannot have private abstract method -> needs to be implemented in other class
    // private doesn't allow access in other class.

    // Abstract Static
    // static abstract void staticAbstractMethod();
    // Illegal combination of modifiers: 'abstract' and 'static'
    // static means the method is shared across all instances
    // abstract means the method will need to be implemented by the extending class.
}

interface InterfaceAccessModifiersExample {

    // Variables
    // public, static final -> all givens -> implicit -> can be excluded
    public static final int i = 0;
    int sameAsI = 0;
    // NB: cannot have access modifiers other than public
    // protected int protectedI = 0;
    int actuallyPublicI = 0;        // Normally it would be package level access except this is an interface where public is implicit
    // private int privateI = 0;

    // Methods

}
