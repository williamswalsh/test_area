import java.util.function.Function;

public class TimeComparison {
    public static void main(String[] args) {
        System.out.println(getDuration(OrderType::valueOfNameStreams));
        System.out.println(getDuration(OrderType::valueOfNameForEach));
    }

    private static long getDuration(Function<String, OrderType> method) {
        long startTime = System.nanoTime();
        method.apply("paper_copy");
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }
}
