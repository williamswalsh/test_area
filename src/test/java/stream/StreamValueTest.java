package stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
}
