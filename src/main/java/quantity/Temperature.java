package quantity;

public class Temperature extends Measurement<Temperature> {
    public enum TemperatureType implements Type {
        CELSIUS(0, 1),
        KELVIN(273.15, 1),
        FAHRENHEIT(32, 0.55);

        private final double multiplicationFactor;
        private final double subtractionFactor;

        TemperatureType(double subtractionFactor, double multiplicationFactor) {
            this.subtractionFactor = subtractionFactor;
            this.multiplicationFactor = multiplicationFactor;
        }

        public double getSubtractionFactor() {
            return this.subtractionFactor;
        }

        public double getMultiplicationFactor() {
            return this.multiplicationFactor;
        }

    }

    public Temperature(double value, TemperatureType temperatureType) {
        super(value, temperatureType);
    }
}
