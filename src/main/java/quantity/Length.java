package quantity;

public class Length extends ScalarMeasurement<Length> {
    public enum LengthType implements Type {
        CENTIMETER(0, 0.01),
        METER(0, 1),
        KILOMETER(0, 1000);

        private final double multiplicationFactor;
        private final double subtractionFactor;

        LengthType(double subtractionFactor, double multiplicationFactor) {
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

    private final LengthType lengthName;

    public Length(double value, LengthType lengthName) throws InValidQuantityValueException {
        super(value, lengthName);
        this.lengthName = lengthName;
    }

    protected Length createObject(double value) throws InValidQuantityValueException {
        return new Length(value, LengthType.METER);
    }
}
