public class Car {
    private final String finalEngineBlock;
    private String nonFinalWheels;
    final String finalEngineOil;

    private Car(String finalEngineBlock, String finalEngineOil) {
        this.finalEngineBlock = finalEngineBlock;
        this.finalEngineOil = finalEngineOil;
    }
}
