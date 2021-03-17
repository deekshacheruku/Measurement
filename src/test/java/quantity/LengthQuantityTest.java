package quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LengthQuantityTest {
    @Test
    void testIs1CentimeterEquals1Centimeter() throws InValidQuantityValueException {
        LengthQuantity firstQuantity = new LengthQuantity(1, LengthType.CENTIMETER);
        LengthQuantity secondQuantity = new LengthQuantity(1, LengthType.CENTIMETER);

        boolean actualResult = firstQuantity.equals(secondQuantity);

        assertTrue(actualResult);
    }

    @Test
    void testIs1CentimeterNotEquals2Centimeter() throws InValidQuantityValueException {
        LengthQuantity firstQuantity = new LengthQuantity(1, LengthType.CENTIMETER);
        LengthQuantity secondQuantity = new LengthQuantity(2, LengthType.CENTIMETER);

        boolean actualResult = firstQuantity.equals(secondQuantity);

        assertFalse(actualResult);
    }

    @Test
    void testThrowsExceptionWhenQuantityValueIsZero() {
        assertThrows(InValidQuantityValueException.class, () -> new LengthQuantity(0, LengthType.CENTIMETER));
    }

    @Test
    void testThrowsExceptionWhenQuantityValueIsNegative() {
        assertThrows(InValidQuantityValueException.class, () -> new LengthQuantity(-1, LengthType.CENTIMETER));
    }

    @Test
    void testIf1MeterEquals100Centimeter() throws InValidQuantityValueException {
        LengthQuantity quantityInMeters = new LengthQuantity(1, LengthType.METER);
        LengthQuantity quantityInCentimeter = new LengthQuantity(100, LengthType.CENTIMETER);

        boolean actualResult = quantityInMeters.equals(quantityInCentimeter);

        assertTrue(actualResult);
    }

    @Test
    void testIf2MetersNotEquals100Centimeter() throws InValidQuantityValueException {
        LengthQuantity quantityInMeters = new LengthQuantity(2, LengthType.METER);
        LengthQuantity quantityInCentimeter = new LengthQuantity(100, LengthType.CENTIMETER);

        boolean actualResult = quantityInMeters.equals(quantityInCentimeter);

        assertFalse(actualResult);
    }

    @Test
    void test100CentimeterEquals0_001Kilometer() throws InValidQuantityValueException {
        LengthQuantity quantityInCentimeters = new LengthQuantity(100, LengthType.CENTIMETER);
        LengthQuantity quantityInKilometers = new LengthQuantity(0.001, LengthType.KILOMETER);

        boolean actualResult = quantityInCentimeters.equals(quantityInKilometers);

        assertTrue(actualResult);
    }

    @Test
    void test1000CentimeterNotEquals0_001Kilometer() throws InValidQuantityValueException {
        LengthQuantity quantityInKilometer = new LengthQuantity(0.001, LengthType.KILOMETER);
        LengthQuantity quantityInCentimeter = new LengthQuantity(1000, LengthType.CENTIMETER);

        boolean actualResult = quantityInCentimeter.equals(quantityInKilometer);

        assertFalse(actualResult);
    }

    @Test
    void testIfAdditionOf1MeterAnd100CentimeterEquals2Meter() throws InValidQuantityValueException {
        LengthQuantity _1Meter = new LengthQuantity(1, LengthType.METER);
        LengthQuantity _100Centimeter = new LengthQuantity(100, LengthType.CENTIMETER);
        LengthQuantity expectedSum = new LengthQuantity(2, LengthType.METER);

        LengthQuantity actualSum = _1Meter.add(_100Centimeter);
        boolean actualResult = actualSum.equals(expectedSum);

        assertTrue(actualResult);
    }

    @Test
    void testIfAdditionOf200CentimeterAnd1KilometerEquals1002Meter() throws InValidQuantityValueException {
        LengthQuantity _200Centimeter = new LengthQuantity(200, LengthType.CENTIMETER);
        LengthQuantity _1Kilometer = new LengthQuantity(1, LengthType.KILOMETER);
        LengthQuantity expectedSum = new LengthQuantity(1002, LengthType.METER);

        LengthQuantity actualSum = _200Centimeter.add(_1Kilometer);
        boolean actualResult = actualSum.equals(expectedSum);

        assertTrue(actualResult);
    }

    @Test
    void testIfAdditionOf1MeterAnd100CentimeterNotEquals1Meter() throws InValidQuantityValueException {
        LengthQuantity _1Meter = new LengthQuantity(1, LengthType.METER);
        LengthQuantity _100Centimeter = new LengthQuantity(100, LengthType.CENTIMETER);
        LengthQuantity expectedSum = new LengthQuantity(1, LengthType.METER);

        LengthQuantity actualSum = _1Meter.add(_100Centimeter);
        boolean actualResult = actualSum.equals(expectedSum);

        assertFalse(actualResult);
    }

    @Test
    void testIfSubtractionOf1MeterAnd50CentimeterEquals0_5Meter() throws InValidQuantityValueException, NegativeSubtractionException {
        LengthQuantity _1Meter = new LengthQuantity(1, LengthType.METER);
        LengthQuantity _0_5Centimeter = new LengthQuantity(50, LengthType.CENTIMETER);
        LengthQuantity expectedDifference = new LengthQuantity(0.5, LengthType.METER);

        LengthQuantity actualDifference = _1Meter.subtract(_0_5Centimeter);
        boolean actualResult = actualDifference.equals(expectedDifference);

        assertTrue(actualResult);
    }

    @Test
    void testIfSubtractionOf2000CentimeterAnd1MeterEquals19Meter() throws InValidQuantityValueException, NegativeSubtractionException {
        LengthQuantity _2000Centimeter = new LengthQuantity(2000, LengthType.CENTIMETER);
        LengthQuantity _1Meter = new LengthQuantity(1, LengthType.METER);
        LengthQuantity expectedDifference = new LengthQuantity(19, LengthType.METER);

        LengthQuantity actualDifference = _2000Centimeter.subtract(_1Meter);
        boolean actualResult = actualDifference.equals(expectedDifference);

        assertTrue(actualResult);
    }

    @Test
    void testIfSubtractionOf3MeterAnd100CentimeterNotEquals1Meter() throws InValidQuantityValueException, NegativeSubtractionException {
        LengthQuantity _3Meter = new LengthQuantity(3, LengthType.METER);
        LengthQuantity _100Centimeter = new LengthQuantity(100, LengthType.CENTIMETER);
        LengthQuantity expectedDifference = new LengthQuantity(1, LengthType.METER);

        LengthQuantity actualDifference = _3Meter.subtract(_100Centimeter);
        boolean actualResult = actualDifference.equals(expectedDifference);

        assertFalse(actualResult);
    }

    @Test
    void testThrowsExceptionIfGreaterQuantitySubtractedFromSmallerQuantity() throws InValidQuantityValueException {
        LengthQuantity largerQuantity = new LengthQuantity(2, LengthType.KILOMETER);
        LengthQuantity smallerQuantity = new LengthQuantity(1, LengthType.METER);

        assertThrows(NegativeSubtractionException.class, () -> smallerQuantity.subtract(largerQuantity));
    }
}