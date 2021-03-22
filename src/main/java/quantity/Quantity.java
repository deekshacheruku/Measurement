package quantity;

@SuppressWarnings("rawtypes")
public abstract class Quantity<T extends Quantity> {
    double value;
    Type type;

    public Quantity(double value, Type type) throws InValidQuantityValueException {
        if (value <= 0)
            throw new InValidQuantityValueException("Length Quantity doesn't support Negative Or Zero Values");
        this.value = value;
        this.type = type;
    }

    public double convertQuantityValueInSIUnit(T quantity) {
        return quantity.value * quantity.type.getConvertingFactor();
    }

    @SuppressWarnings({"unchecked"})
    public T add(T quantity) throws InValidQuantityValueException {
        return createObject(convertQuantityValueInSIUnit((T) this) +
                convertQuantityValueInSIUnit(quantity));
    }

    protected abstract T createObject(double value) throws InValidQuantityValueException;

    @SuppressWarnings({"unchecked"})
    public T subtract(T quantity) throws NegativeSubtractionException, InValidQuantityValueException {
        double firstDifference = convertQuantityValueInSIUnit((T) this);
        double secondDifference = convertQuantityValueInSIUnit(quantity);
        if (firstDifference < secondDifference)
            throw new NegativeSubtractionException("Greater Quantity can't be subtracted from smaller Quantity");
        return createObject(firstDifference - secondDifference);
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        T quantity = (T) o;
        return convertQuantityValueInSIUnit((T) this) == convertQuantityValueInSIUnit(quantity);
    }
}
