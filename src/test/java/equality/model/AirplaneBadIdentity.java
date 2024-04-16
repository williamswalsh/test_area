package equality.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class AirplaneBadIdentity {

    private UUID uuid;
    private Make make;
    private Model model;

    public AirplaneBadIdentity(UUID uuid, Make make, Model model) {
        this.uuid = uuid;
        this.make = make;
        this.model = model;
    }


//    ID based on uuid field only
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AirplaneBadIdentity that = (AirplaneBadIdentity) o;

        return uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        // All objects have same hashcode - will cause problems when using hash based data-structures.
        return 1;
    }

    @Override
    public String toString() {
        return "AirplaneBadIdentity{" +
                "uuid=" + uuid +
                ", make=" + make +
                ", model=" + model +
                '}';
    }
}
