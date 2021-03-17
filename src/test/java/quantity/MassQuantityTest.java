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

    @Test
    void test0_1KiloGramsEquals100Grams() throws InValidQuantityValueException {
        MassQuantity _0_1KiloGrams = new MassQuantity(0.1,MassType.KILOGRAM);
        MassQuantity _100Grams = new MassQuantity(100,MassType.GRAM);

        assertTrue(_0_1KiloGrams.equals(_100Grams));
    }

    @Test
    void test100KiloGramsNotEquals1Grams() throws InValidQuantityValueException {
        MassQuantity _100KiloGrams = new MassQuantity(100,MassType.KILOGRAM);
        MassQuantity _1Grams = new MassQuantity(1,MassType.GRAM);

        assertFalse(_100KiloGrams.equals(_1Grams));
    }
}
