package quantity;

@SuppressWarnings("rawtypes")
public abstract class ScalarMeasurement<T extends ScalarMeasurement> extends Measurement<ScalarMeasurement> {

    public ScalarMeasurement(double value, Type type) throws InValidQuantityValueException {
        super(value, type);
        if (value <= 0)
            throw new InValidQuantityValueException("Scalar Quantity doesn't support Negative Or Zero Values");
    }

    protected abstract T createObject(double value) throws InValidQuantityValueException;

    @SuppressWarnings({"unchecked"})
    public T add(T quantity) throws InValidQuantityValueException {
        return createObject(this.convertQuantityIntoSIUnit() + quantity.convertQuantityIntoSIUnit());
    }

    @SuppressWarnings({"unchecked"})
    public T subtract(T quantity) throws NegativeSubtractionException, InValidQuantityValueException {
        double firstDifference = this.convertQuantityIntoSIUnit();
        double secondDifference = quantity.convertQuantityIntoSIUnit();
        if (firstDifference < secondDifference)
            throw new NegativeSubtractionException("Greater Quantity can't be subtracted from smaller Quantity");
        return createObject(firstDifference - secondDifference);
    }
}
