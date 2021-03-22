package quantity;

@SuppressWarnings("rawtypes")
public class Measurement<T extends Measurement> {
    interface Type {
        double getSubtractionFactor();

        double getMultiplicationFactor();
    }

    final double value;
    final Type type;

    public Measurement(double value, Type type) {
        this.value = value;
        this.type = type;
    }

    double convertQuantityIntoSIUnit(T quantity) {
        return (quantity.value - quantity.type.getSubtractionFactor()) * quantity.type.getMultiplicationFactor();
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        T quantity = (T) o;
        return convertQuantityIntoSIUnit((T) this) == convertQuantityIntoSIUnit(quantity);
    }
}
