package junit_testing;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.UUID;

public class RuleTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void shouldThrowRuntimeExceptionWhenEmployeeIDisNull() throws Exception {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Employee ID is null");
        method();
    }

    public void method() {
        System.out.println("=======Starting Exception process=======");
        throw new RuntimeException("Employee ID is null");
    }
}
