package quantity;

public class Length extends Quantity<Length> {

    public double value;
    public QuantityType.LengthType lengthName;

    public Length(double value, QuantityType.LengthType lengthName) throws InValidQuantityValueException {
        super(value, lengthName);
        this.value = value;
        this.lengthName = lengthName;
    }

    public Length createObject(double value) throws InValidQuantityValueException {
        return new Length(value, QuantityType.LengthType.METER);
    }
}
