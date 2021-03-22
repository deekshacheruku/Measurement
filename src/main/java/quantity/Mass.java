package quantity;

public class Mass extends Quantity<Mass> {

    public double value;
    public QuantityType.MassType massName;

    public Mass(double value, QuantityType.MassType massName) throws InValidQuantityValueException {
        super(value, massName);
        this.value = value;
        this.massName = massName;
    }

    @Override
    protected Mass createObject(double value) throws InValidQuantityValueException {
        return new Mass(value, QuantityType.MassType.GRAM);
    }

}
