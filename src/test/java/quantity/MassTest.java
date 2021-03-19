package quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MassTest {
    @Test
    void testIf1GramEquals1Gram() throws InValidQuantityValueException {
        Mass firstQuantity = new Mass(1, QuantityType.Mass.GRAM);
        Mass secondQuantity = new Mass(1, QuantityType.Mass.GRAM);

        assertEquals(firstQuantity, secondQuantity);
    }

    @Test
    void testIf1GramNotEquals2Gram() throws InValidQuantityValueException {
        Mass firstQuantity = new Mass(1, QuantityType.Mass.GRAM);
        Mass secondQuantity = new Mass(2, QuantityType.Mass.GRAM);

        assertNotEquals(secondQuantity, firstQuantity);
    }

    @Test
    void testExceptionIfMassValueIsZero() {
        assertThrows(InValidQuantityValueException.class, () -> new Mass(0, QuantityType.Mass.GRAM));
    }

    @Test
    void testExceptionIfMassValueIsNegative() {
        assertThrows(InValidQuantityValueException.class, () -> new Mass(-2, QuantityType.Mass.GRAM));
    }

    @Test
    void test0_1KiloGramsEquals100Grams() throws InValidQuantityValueException {
        Mass kiloGrams0_1 = new Mass(0.1, QuantityType.Mass.KILOGRAM);
        Mass grams100 = new Mass(100, QuantityType.Mass.GRAM);

        assertEquals(grams100, kiloGrams0_1);
    }

    @Test
    void test100KiloGramsNotEquals1Grams() throws InValidQuantityValueException {
        Mass kiloGrams100 = new Mass(100, QuantityType.Mass.KILOGRAM);
        Mass gram1 = new Mass(1, QuantityType.Mass.GRAM);

        assertNotEquals(gram1, kiloGrams100);
    }

    @Test
    void testAdditionOf10GramsAnd1KiloGramsEquals1010Grams() throws InValidQuantityValueException {
        Mass grams10 = new Mass(10, QuantityType.Mass.GRAM);
        Mass kiloGrams1 = new Mass(1, QuantityType.Mass.KILOGRAM);
        Mass expectedSum = new Mass(1010, QuantityType.Mass.GRAM);

        Mass actualSum = grams10.add(kiloGrams1);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    void testAdditionOf1GramsAnd1KiloGramsNotEquals2Grams() throws InValidQuantityValueException {
        Mass gram1 = new Mass(1, QuantityType.Mass.GRAM);
        Mass kiloGram1 = new Mass(1, QuantityType.Mass.KILOGRAM);
        Mass expectedSum = new Mass(2, QuantityType.Mass.GRAM);

        Mass actualSum = gram1.add(kiloGram1);

        assertNotEquals(expectedSum, actualSum);
    }

    @Test
    void testSubtractionOf500GramsFrom1_5KiloGramsEquals1000Grams() throws InValidQuantityValueException, NegativeSubtractionException {
        Mass kilograms1_5 = new Mass(1.5, QuantityType.Mass.KILOGRAM);
        Mass grams500 = new Mass(500, QuantityType.Mass.GRAM);
        Mass expectedDifference = new Mass(1000, QuantityType.Mass.GRAM);

        Mass actualDifference = kilograms1_5.subtract(grams500);

        assertEquals(expectedDifference, actualDifference);
    }

    @Test
    void testSubtractionOf500GramsFrom1_5KiloGramsNotEquals500Grams() throws InValidQuantityValueException, NegativeSubtractionException {
        Mass grams1_5 = new Mass(1.5, QuantityType.Mass.KILOGRAM);
        Mass grams500 = new Mass(500, QuantityType.Mass.GRAM);
        Mass expectedDifference = new Mass(500, QuantityType.Mass.GRAM);

        Mass actualDifference = grams1_5.subtract(grams500);

        assertNotEquals(expectedDifference, actualDifference);
    }

    @Test
    void testThrowsExceptionIfGreaterQuantitySubtractedFromSmallerQuantity() throws InValidQuantityValueException {
        Mass largerQuantity = new Mass(2, QuantityType.Mass.KILOGRAM);
        Mass smallerQuantity = new Mass(1, QuantityType.Mass.GRAM);

        assertThrows(NegativeSubtractionException.class, () -> smallerQuantity.subtract(largerQuantity));
    }
}
