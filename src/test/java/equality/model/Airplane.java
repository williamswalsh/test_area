package equality.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Airplane{
    private Make make;
    private Model model;

    public Airplane(Make make, Model model) {
        this.make = make;
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        equality.model.Airplane airplane = (equality.model.Airplane) o;

        if (make != airplane.make) return false;
        return model == airplane.model;
    }

    @Override
    public int hashCode() {
        int result = make.hashCode();
        result = 31 * result + model.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "make=" + make +
                ", model=" + model +
                '}';
    }
}
