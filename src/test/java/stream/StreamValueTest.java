package stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamValueTest {

    @Test(expected = NullPointerException.class)
    public void nullListToStreamTest() {
        List<String> nullList = null;
        // nullList.stream().forEach(System.out::println);
        nullList.stream().map((s -> s + " suffix"));
    }

    @Test
    public void emptyListToStreamTest() {
        List<String> emptyList = new ArrayList<>();
        // emptyList.stream().forEach(System.out::println);
        emptyList.stream().map((s -> s + " suffix"));
    }


    @Test
    public void streamsDemo() {
        List<String> names = new ArrayList<>();
        names.add("alice");
        names.add("bob");
        names.add("claire");

        List<String> upperCaseNames = names.stream()
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());

    //            .forEach(name -> System.out.println(name))
    }
}
