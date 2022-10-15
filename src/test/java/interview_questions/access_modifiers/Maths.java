package interview_questions.access_modifiers;

/**
 * @author William Walsh
 * @version 15 Oct 2022
 */
class Maths {
    public static double publicPi = 3.14;
    static double packagePi = 3.14;
    private static double privatePi = 3.14;
    protected static double protectedPi = 3.14;

    void method() {
        System.out.println(Maths.privatePi * 2);
    }
}