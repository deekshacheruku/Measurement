package quantity;

public class Quantity {
    private double value;
    private QuantityType quantityName;

    public Quantity(double value, QuantityType quantityName) throws InValidQuantityValueException {
        if (value <= 0)
            throw new InValidQuantityValueException("Quantity doesn't support Negative Or Zero Values");
        this.value = value;
        this.quantityName = quantityName;
    }

    private double convertQuantityValueInToMeters(Quantity quantity) {
        if (quantity.quantityName.name().equals("CENTIMETER"))
            return quantity.value / 100;
        else if (quantity.quantityName.name().equals("KILOMETER"))
            return quantity.value * 1000;
        return quantity.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity = (Quantity) o;
        return convertQuantityValueInToMeters(quantity) == convertQuantityValueInToMeters(this);
    }
}
