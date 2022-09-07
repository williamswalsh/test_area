package jackson.construction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Car {
    private int numOfWheels;
    private String brand;
    private String model;
}
