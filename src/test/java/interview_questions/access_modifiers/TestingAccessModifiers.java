package interview_questions.access_modifiers;

import org.junit.Test;

/**
 * @author William Walsh
 * @version 15 Oct 2022
 */
public class TestingAccessModifiers {
    @Test
    public void test() {
        System.out.println(Maths.publicPi);
        System.out.println(Maths.packagePi);
        System.out.println(Maths.protectedPi);
    }
}





