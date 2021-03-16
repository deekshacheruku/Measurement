package quantity;

public class Quantity {
    private double value ;
    private QuantityType quantityName;

    public Quantity(double value, QuantityType quantityName) throws InValidQuantityValueException {
        if(value <= 0)
            throw new InValidQuantityValueException("Quantity doesn't support Negative Or Zero Values");
        this.value = value;
        this.quantityName = quantityName;
    }

    @Override
    public boolean equals(Object o){
        Quantity quantity = (Quantity) o;
        return this.value == quantity.value;
    }
}
