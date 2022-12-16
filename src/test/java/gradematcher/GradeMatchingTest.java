package gradematcher;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author William Walsh
 * @version 16 Dec 2022
 */
public class GradeMatchingTest {

    @Test
    public void matcherTestWithNullGrade() {
        String result = new GradeMatchingTest().matcher(null);
        assertEquals("Blank grade is to be added to list.", result);
    }

    @Test
    public void matcherTestWithA1Grade() {
        String result = new GradeMatchingTest().matcher("A1");
        assertEquals("Grade: A1 is to be added to list", result);
    }

    @Test
    public void matcherTestWithValidGrade() {
        String correctGrade = "C3";
        String result = new GradeMatchingTest().matcher(correctGrade);
        assertEquals("Grade: " + correctGrade + " is to be added to list", result);
    }

    @Test
    public void matcherTestWithIncorrectGrade() {
        String incorrectGrade = "X5";
        String result = new GradeMatchingTest().matcher(incorrectGrade);
        assertEquals("Grade: " + incorrectGrade + " is NOT to be added to list", result);
    }

    String matcher(String grade) {
        if (grade == null) {

            grade = "";
            return "Blank grade is to be added to list.";

        } else if (grade.toUpperCase().matches("A1|A2|B1|B2|B3|C1|C2|C3|D1|D2|P|P1|P2")) {

            return "Grade: " + grade + " is to be added to list";

        } else {
            return "Grade: " + grade + " is NOT to be added to list";
        }
    }
}
