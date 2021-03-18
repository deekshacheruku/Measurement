package quantity;

public class Length implements Quantity {
    private final double value;
    private final QuantityType.Length lengthName;

    public Length(double value, QuantityType.Length quantityName) throws InValidQuantityValueException {
        if (value <= 0)
            throw new InValidQuantityValueException("Length Quantity doesn't support Negative Or Zero Values");
        this.value = value;
        this.lengthName = quantityName;
    }

    private double convertQuantityValueInToMeters(Length quantity) {
        if (quantity.lengthName.name().equals("CENTIMETER"))
            return quantity.value / 100;
        else if (quantity.lengthName.name().equals("KILOMETER"))
            return quantity.value * 1000;
        return quantity.value;
    }

    public Length add(Object quantity) throws InValidQuantityValueException {
        double valueInMeter = convertQuantityValueInToMeters(this) + convertQuantityValueInToMeters((Length) quantity);
        return new Length(valueInMeter, QuantityType.Length.METER);
    }

    public Length subtract(Object quantity) throws InValidQuantityValueException, NegativeSubtractionException {
        double firstQuantity = convertQuantityValueInToMeters(this);
        double secondQuantity = convertQuantityValueInToMeters((Length) quantity);
        if (firstQuantity < secondQuantity)
            throw new NegativeSubtractionException("Larger Quantity Value can't be subtracted from Smaller Quantity");
        double valueInMeter = firstQuantity - secondQuantity;
        return new Length(valueInMeter, QuantityType.Length.METER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length quantity = (Length) o;
        return convertQuantityValueInToMeters(quantity) == convertQuantityValueInToMeters(this);
    }
}
