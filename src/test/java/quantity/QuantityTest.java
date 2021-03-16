package quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityTest {
    @Test
    void testIs1CentimeterEquals1Centimeter() throws InValidQuantityValueException {
        Quantity firstQuantity = new Quantity(1, QuantityType.CENTIMETER);
        Quantity secondQuantity = new Quantity(1, QuantityType.CENTIMETER);

        assertTrue(firstQuantity.equals(secondQuantity));
    }

    @Test
    void testIs1CentimeterNotEquals2Centimeter() throws InValidQuantityValueException {
        Quantity firstQuantity = new Quantity(1, QuantityType.CENTIMETER);
        Quantity secondQuantity = new Quantity(2, QuantityType.CENTIMETER);

        assertFalse(firstQuantity.equals(secondQuantity));
    }

    @Test
    void testThrowsExceptionWhenQuantityValueIsZero() {
        assertThrows(InValidQuantityValueException.class, () -> new Quantity(0, QuantityType.CENTIMETER));
    }

    @Test
    void testThrowsExceptionWhenQuantityValueIsNegative() {
        assertThrows(InValidQuantityValueException.class, () -> new Quantity(-1,QuantityType.CENTIMETER));
    }
}
