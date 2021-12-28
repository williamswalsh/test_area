import java.util.stream.Stream;

public enum OrderType {

    DIGITAL("digital"), PAPER_COPY("paper_copy");

    private final String name;

    private OrderType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static OrderType valueOfNameStreams(String name) {
        return Stream.of(OrderType.values()).filter(n -> n.getName().equals(name)).findAny()
                .orElseThrow(() -> new RuntimeException("Unsupported value " + name));
    }

    public static OrderType valueOfNameForEach(String name) {
        for(OrderType type: OrderType.values()) {
            if(type.getName().equals(name)) {
                return type;
            }
        }
        throw new RuntimeException("Unsupported value " + name);
    }
}
