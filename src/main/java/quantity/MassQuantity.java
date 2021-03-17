package quantity;

public class MassQuantity {
    private double value;
    private MassType massName;

    public MassQuantity(double value, MassType massName) throws InValidQuantityValueException {
        if(value <= 0)
            throw new InValidQuantityValueException("Mass Quantity doesn't support Zero or Negative Values");
        this.value = value;
        this.massName = massName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MassQuantity quantity = (MassQuantity) o;
        return convertQuantityValueInToGrams(quantity) == convertQuantityValueInToGrams(this);
    }

    private double convertQuantityValueInToGrams(MassQuantity quantity) {
        if(quantity.massName.name().equals("KILOGRAM"))
            return quantity.value /1000;
        return quantity.value;
    }
}
