package quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuantityTest {
    @Test
    void testIs1CentimeterEquals1Centimeter() {
        Quantity firstQuantity = new Quantity(1, QuantityType.CENTIMETER);
        Quantity secondQuantity = new Quantity(1, QuantityType.CENTIMETER);

        assertTrue(firstQuantity.equals(secondQuantity));
    }

    @Test
    void testIs1CentimeterNotEquals2Centimeter() {
        Quantity firstQuantity = new Quantity(1, QuantityType.CENTIMETER);
        Quantity secondQuantity = new Quantity(2, QuantityType.CENTIMETER);

        assertFalse(firstQuantity.equals(secondQuantity));
    }
}
