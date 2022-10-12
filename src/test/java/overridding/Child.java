package overridding;

/**
 * @author William Walsh
 * @version 11 Oct 2022
 */
public class Child extends Parent {

    @Override
    protected String speak(String name) {
        return "Child saying my name, " + name;
    }
}
