package quantity;

public class Mass extends ScalarMeasurement<Mass> {
    public enum MassType implements Type {
        GRAM(0, 1),
        KILOGRAM(0, 1000);

        private final double multiplicationFactor;
        private final double subtractionFactor;

        MassType(double subtractionFactor, double multiplicationFactor) {
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

    private MassType massName;

    public Mass(double value, MassType massName) throws InValidQuantityValueException {
        super(value, massName);
        this.massName = massName;
    }

    @Override
    protected Mass createObject(double value) throws InValidQuantityValueException {
        return new Mass(value, MassType.GRAM);
    }

}
