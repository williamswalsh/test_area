package equality.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class AirplaneWithUuid {

    private UUID uuid;
    private Make make;
    private Model model;

    public AirplaneWithUuid(UUID uuid, Make make, Model model) {
        this.uuid = uuid;
        this.make = make;
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AirplaneWithUuid that = (AirplaneWithUuid) o;

        return uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return "AirplaneWithUuid{" +
                "uuid=" + uuid +
                ", make=" + make +
                ", model=" + model +
                '}';
    }
}
