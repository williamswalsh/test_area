package reflection;

import lombok.AllArgsConstructor;

/**
 * @author William Walsh
 * @version 07 Sep 2022
 */
@AllArgsConstructor
public class SampleClass {
    // members
    public String publicString;
    protected String protectedString;
    String defaultString;
    private String privateString;

    // methods
    public void publicMethod() {
        System.out.println("This is a public method.");
    }

    protected void protectedMethod() {
        System.out.println("This is a protected method.");
    }

    void defaultMethod() {
        System.out.println("This is a default method.");
    }

    private void privateMethod() {
        System.out.println("This is a private method.");
    }
}
