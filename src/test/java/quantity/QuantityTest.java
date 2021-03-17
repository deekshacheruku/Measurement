package quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityTest {
    @Test
    void testIs1CentimeterEquals1Centimeter() throws InValidQuantityValueException {
        Quantity firstQuantity = new Quantity(1, QuantityType.CENTIMETER);
        Quantity secondQuantity = new Quantity(1, QuantityType.CENTIMETER);

        boolean actualResult = firstQuantity.equals(secondQuantity);

        assertTrue(actualResult);
    }

    @Test
    void testIs1CentimeterNotEquals2Centimeter() throws InValidQuantityValueException {
        Quantity firstQuantity = new Quantity(1, QuantityType.CENTIMETER);
        Quantity secondQuantity = new Quantity(2, QuantityType.CENTIMETER);

        boolean actualResult = firstQuantity.equals(secondQuantity);

        assertFalse(actualResult);
    }

    @Test
    void testThrowsExceptionWhenQuantityValueIsZero() {
        assertThrows(InValidQuantityValueException.class, () -> new Quantity(0, QuantityType.CENTIMETER));
    }

    @Test
    void testThrowsExceptionWhenQuantityValueIsNegative() {
        assertThrows(InValidQuantityValueException.class, () -> new Quantity(-1, QuantityType.CENTIMETER));
    }

    @Test
    void testIf1MeterEquals100Centimeter() throws InValidQuantityValueException {
        Quantity quantityInMeters = new Quantity(1, QuantityType.METER);
        Quantity quantityInCentimeter = new Quantity(100, QuantityType.CENTIMETER);

        boolean actualResult = quantityInMeters.equals(quantityInCentimeter);

        assertTrue(actualResult);
    }

    @Test
    void testIf2MetersNotEquals100Centimeter() throws InValidQuantityValueException {
        Quantity quantityInMeters = new Quantity(2, QuantityType.METER);
        Quantity quantityInCentimeter = new Quantity(100, QuantityType.CENTIMETER);

        boolean actualResult = quantityInMeters.equals(quantityInCentimeter);

        assertFalse(actualResult);
    }

    @Test
    void test100CentimeterEquals0_001Kilometer() throws InValidQuantityValueException {
        Quantity quantityInCentimeters = new Quantity(100, QuantityType.CENTIMETER);
        Quantity quantityInKilometers = new Quantity(0.001, QuantityType.KILOMETER);

        boolean actualResult = quantityInCentimeters.equals(quantityInKilometers);

        assertTrue(actualResult);
    }

    @Test
    void test1000CentimeterNotEquals0_001Kilometer() throws InValidQuantityValueException {
        Quantity quantityInKilometer = new Quantity(0.001, QuantityType.KILOMETER);
        Quantity quantityInCentimeter = new Quantity(1000, QuantityType.CENTIMETER);

        boolean actualResult = quantityInCentimeter.equals(quantityInKilometer);

        assertFalse(actualResult);
    }

    @Test
    void testIfAdditionOf1MeterAnd100CentimeterEquals2Meter() throws InValidQuantityValueException {
        Quantity _1Meter = new Quantity(1, QuantityType.METER);
        Quantity _100Centimeter = new Quantity(100, QuantityType.CENTIMETER);
        Quantity expectedSum = new Quantity(2, QuantityType.METER);

        Quantity actualSum = _1Meter.add(_100Centimeter);
        boolean actualResult = actualSum.equals(expectedSum);

        assertTrue(actualResult);
    }

    @Test
    void testIfAdditionOf200CentimeterAnd1KilometerEquals1002Meter() throws InValidQuantityValueException {
        Quantity _200Centimeter = new Quantity(200, QuantityType.CENTIMETER);
        Quantity _1Kilometer = new Quantity(1, QuantityType.KILOMETER);
        Quantity expectedSum = new Quantity(1002, QuantityType.METER);

        Quantity actualSum = _200Centimeter.add(_1Kilometer);
        boolean actualResult = actualSum.equals(expectedSum);

        assertTrue(actualResult);
    }

    @Test
    void testIfAdditionOf1MeterAnd100CentimeterNotEquals1Meter() throws InValidQuantityValueException {
        Quantity _1Meter = new Quantity(1, QuantityType.METER);
        Quantity _100Centimeter = new Quantity(100, QuantityType.CENTIMETER);
        Quantity expectedSum = new Quantity(1, QuantityType.METER);

        Quantity actualSum = _1Meter.add(_100Centimeter);
        boolean actualResult = actualSum.equals(expectedSum);

        assertFalse(actualResult);
    }

    @Test
    void testIfSubtractionOf1MeterAnd50CentimeterEquals0_5Meter() throws InValidQuantityValueException, NegativeSubtractionException {
        Quantity _1Meter = new Quantity(1, QuantityType.METER);
        Quantity _0_5Centimeter = new Quantity(50, QuantityType.CENTIMETER);
        Quantity expectedSum = new Quantity(0.5, QuantityType.METER);

        Quantity actualSum = _1Meter.subtract(_0_5Centimeter);
        boolean actualResult = actualSum.equals(expectedSum);

        assertTrue(actualResult);
    }

    @Test
    void testIfSubtractionOf2000CentimeterAnd1MeterEquals19Meter() throws InValidQuantityValueException, NegativeSubtractionException {
        Quantity _2000Centimeter = new Quantity(2000, QuantityType.CENTIMETER);
        Quantity _1Meter = new Quantity(1, QuantityType.METER);
        Quantity expectedSum = new Quantity(19, QuantityType.METER);

        Quantity actualSum = _2000Centimeter.subtract(_1Meter);
        boolean actualResult = actualSum.equals(expectedSum);

        assertTrue(actualResult);
    }

    @Test
    void testIfSubtractionOf3MeterAnd100CentimeterNotEquals1Meter() throws InValidQuantityValueException, NegativeSubtractionException {
        Quantity _3Meter = new Quantity(3, QuantityType.METER);
        Quantity _100Centimeter = new Quantity(100, QuantityType.CENTIMETER);
        Quantity expectedSum = new Quantity(1, QuantityType.METER);

        Quantity actualSum = _3Meter.subtract(_100Centimeter);
        boolean actualResult = actualSum.equals(expectedSum);

        assertFalse(actualResult);
    }

    @Test
    void testThrowsExceptionIfGreaterQuantitySubtractedFromSmallerQuantity() throws InValidQuantityValueException {
        Quantity largerQuantity =  new Quantity(2,QuantityType.KILOMETER);
        Quantity smallerQuantity =  new Quantity(1,QuantityType.METER);

        assertThrows(NegativeSubtractionException.class, () -> smallerQuantity.subtract(largerQuantity));
    }
}