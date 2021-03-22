package quantity;

public class QuantityType {
    public enum LengthType implements Type {
        CENTIMETER(0.01),
        METER(1),
        KILOMETER(1000);

        private final double convertingFactor;

        LengthType(double convertingFactor) {
            this.convertingFactor = convertingFactor;
        }

        public double getConvertingFactor() {
            return this.convertingFactor;
        }
    }

    public enum MassType implements Type {
        GRAM(1),
        KILOGRAM(1000);

        private final double convertingFactor;

        MassType(double convertingFactor) {
            this.convertingFactor = convertingFactor;
        }

        public double getConvertingFactor() {
            return this.convertingFactor;
        }
    }

    public enum TemperatureType {
        CELSIUS(),
        KELVIN(),
        FAHRENHEIT()
    }
}
