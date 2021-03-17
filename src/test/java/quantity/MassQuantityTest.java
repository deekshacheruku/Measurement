package quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MassQuantityTest {
    @Test
    void testIs1GramEquals1Gram() throws InValidQuantityValueException {
        MassQuantity firstQuantity = new MassQuantity(1,MassType.GRAM);
        MassQuantity secondQuantity = new MassQuantity(1,MassType.GRAM);

        assertTrue(firstQuantity.equals(secondQuantity));
    }

    @Test
    void testIf1GramNotEquals2Gram() throws InValidQuantityValueException {
        MassQuantity firstQuantity = new MassQuantity(1,MassType.GRAM);
        MassQuantity secondQuantity = new MassQuantity(2,MassType.GRAM);

        assertFalse(firstQuantity.equals(secondQuantity));
    }

    @Test
    void testExceptionIfMassValueIsZero() {
        assertThrows(InValidQuantityValueException.class, () -> new MassQuantity(0,MassType.GRAM));
    }

    @Test
    void testExceptionIfMassValueIsNegative() {
        assertThrows(InValidQuantityValueException.class, () -> new MassQuantity(-2,MassType.GRAM));
    }
}
