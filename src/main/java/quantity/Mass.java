package quantity;

public class Mass implements Quantity {
    private final double value;
    private final QuantityType.Mass massName;

    public Mass(double value, QuantityType.Mass massName) throws InValidQuantityValueException {
        if (value <= 0)
            throw new InValidQuantityValueException("Mass Quantity doesn't support Zero or Negative Values");
        this.value = value;
        this.massName = massName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mass quantity = (Mass) o;
        return convertQuantityValueInToGrams(quantity) == convertQuantityValueInToGrams(this);
    }

    private double convertQuantityValueInToGrams(Mass quantity) {
        if (quantity.massName.name().equals("KILOGRAM"))
            return quantity.value * 1000;
        return quantity.value;
    }

    public Mass add(Object quantity) throws InValidQuantityValueException {
        double valueInGram = convertQuantityValueInToGrams(this) + convertQuantityValueInToGrams((Mass) quantity);
        return new Mass(valueInGram, QuantityType.Mass.GRAM);
    }

    public Mass subtract(Object quantity) throws InValidQuantityValueException, NegativeSubtractionException {
        double firstQuantity = convertQuantityValueInToGrams(this);
        double secondQuantity = convertQuantityValueInToGrams((Mass) quantity);
        if (firstQuantity < secondQuantity)
            throw new NegativeSubtractionException("Larger Quantity Value can't be subtracted from Smaller Quantity");
        double valueInGram = firstQuantity - secondQuantity;
        return new Mass(valueInGram, QuantityType.Mass.GRAM);
    }
}
