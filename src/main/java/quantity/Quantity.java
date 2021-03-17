package quantity;

public interface Quantity {
    Object add(Object quantity) throws InValidQuantityValueException;

    Object subtract(Object quantity) throws InValidQuantityValueException, NegativeSubtractionException;
}
