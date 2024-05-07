package pattern;

import equality.model.Make;
import equality.model.Model;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Car {

    private final Make make;
    private final Model model;

    public Car(Make make, Model model) {
//        Haven't used requireNonNull much before.
        this.make = Objects.requireNonNull(make);
        this.model = Objects.requireNonNull(model);
    }

}
