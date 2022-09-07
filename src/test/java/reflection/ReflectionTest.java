package reflection;

import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertFalse;

/**
 * @author William Walsh
 * @version 07 Sep 2022
 */
public class ReflectionTest {

    @Test
    public void testReflectiveJavaApi() throws ClassNotFoundException {

        // Class references
        Class stringClass1 = String.class;
        Class<String> stringClass2 = String.class;
        Class<?> anUnknownClass = String.class;

        // Getting a class from a string
        Class stringClass3 = Class.forName("java.lang.String");     // Can throw ClassNotFoundException
        Class integerClass = Class.forName("java.lang.Integer");

        // Determine if class is instance of Integer
        boolean isInteger1 = stringClass3.isInstance(Integer.class);
        assertFalse("This String class should not be an Integer class.", isInteger1);

        boolean isInteger2 = stringClass3.isInstance(integerClass);
        assertFalse("This String class should not be an Integer class.", isInteger2);
    }

    @Test
    public void testSampleClassGetDeclaredMethods() {
        Class<?> sample = SampleClass.class;

        List<String> methodNames = Arrays.stream(sample.getDeclaredMethods())
                .map(Method::getName)
                .collect(Collectors.toList());

        assertThat(methodNames, contains("publicMethod", "protectedMethod", "defaultMethod", "privateMethod"));
    }

    @Test
    public void testSampleClassGetDeclaredConstructor() {
        Class<?> sample = SampleClass.class;
        Constructor<?> sampleClassConstructor = sample.getDeclaredConstructors()[0];
        System.out.println("Number of parameters in constructor: " + sampleClassConstructor.getParameterCount());
        String combinedParameterTypeNames = Arrays.stream(
                        sampleClassConstructor.getParameterTypes())                     // Stream<Class>
                .map(Object::toString)                                                  // Stream<String>
                .collect(Collectors.joining(", "));                            // String
        System.out.println("Parameter types: " + combinedParameterTypeNames);
    }

    /**
     * Arrays are also a class.
     * So you can interact with Arrays reflectively.
     */
    @Test
    public void testArrays() throws ClassNotFoundException {
        Class cls = Class.forName(
                "java.lang.String");
        Object arr = Array.newInstance(cls, 10);
        Array.set(arr, 5, "this is a test");
        String s = (String) Array.get(arr, 5);
        System.out.println(s);

        // Get array element without value -> null
        // Note that you can cast null without getting a NPE
        System.out.println((String) Array.get(arr, 0));
    }
}
