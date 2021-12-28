package service_testing;

import java.util.*;

public class ComputeIfAbsent {

    public static void main(String[] args) {
        Map<String, List<String>> recipientDocIds = new HashMap<>();



        // add applies to result of Map "value retrieval" using key.
        // add applies to the List that is returned .... ahhhhh
        recipientDocIds.computeIfAbsent("A", k -> new ArrayList<>())
                .add("1");
        recipientDocIds.computeIfAbsent("B", k -> new ArrayList<>())
                .add("2");
        recipientDocIds.computeIfAbsent("B", k -> new ArrayList<>())
                .add("3");
        recipientDocIds.computeIfAbsent("B", k -> new ArrayList<>())
                .add("4");

        System.out.println(recipientDocIds);
    }
}

