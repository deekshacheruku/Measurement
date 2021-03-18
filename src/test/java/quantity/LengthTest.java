package quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LengthTest {
    @Test
    void testIs1CentimeterEquals1Centimeter() throws InValidQuantityValueException {
        Length firstQuantity = new Length(1, QuantityType.Length.CENTIMETER);
        Length secondQuantity = new Length(1, QuantityType.Length.CENTIMETER);

        assertEquals(secondQuantity, firstQuantity);
    }

    @Test
    void testIs1CentimeterNotEquals2Centimeter() throws InValidQuantityValueException {
        Length firstQuantity = new Length(1, QuantityType.Length.CENTIMETER);
        Length secondQuantity = new Length(2, QuantityType.Length.CENTIMETER);

        assertNotEquals(secondQuantity, firstQuantity);
    }

    @Test
    void testThrowsExceptionWhenQuantityValueIsZero() {
        assertThrows(InValidQuantityValueException.class, () -> new Length(0, QuantityType.Length.CENTIMETER));
    }

    @Test
    void testThrowsExceptionWhenQuantityValueIsNegative() {
        assertThrows(InValidQuantityValueException.class, () -> new Length(-1, QuantityType.Length.CENTIMETER));
    }

    @Test
    void testIf1MeterEquals100Centimeter() throws InValidQuantityValueException {
        Length oneMeter = new Length(1, QuantityType.Length.METER);
        Length hundredCentimeter = new Length(100, QuantityType.Length.CENTIMETER);

        assertEquals(hundredCentimeter, oneMeter);
    }

    @Test
    void testIf2MetersNotEquals100Centimeter() throws InValidQuantityValueException {
        Length twoMeters = new Length(2, QuantityType.Length.METER);
        Length hundredCentimeter = new Length(100, QuantityType.Length.CENTIMETER);

        assertNotEquals(hundredCentimeter, twoMeters);
    }

    @Test
    void test100CentimeterEquals0_001Kilometer() throws InValidQuantityValueException {
        Length hundredCentimeters = new Length(100, QuantityType.Length.CENTIMETER);
        Length kilometers0_001 = new Length(0.001, QuantityType.Length.KILOMETER);

        assertEquals(kilometers0_001, hundredCentimeters);
    }

    @Test
    void test1000CentimeterNotEquals0_001Kilometer() throws InValidQuantityValueException {
        Length kilometer0_001 = new Length(0.001, QuantityType.Length.KILOMETER);
        Length thousandCentimeter = new Length(1000, QuantityType.Length.CENTIMETER);

        assertNotEquals(kilometer0_001, thousandCentimeter);
    }

    @Test
    void testIfAdditionOf1MeterAnd100CentimeterEquals2Meter() throws InValidQuantityValueException {
        Length oneMeter = new Length(1, QuantityType.Length.METER);
        Length hundredCentimeter = new Length(100, QuantityType.Length.CENTIMETER);
        Length expectedSum = new Length(2, QuantityType.Length.METER);

        Length actualSum = oneMeter.add(hundredCentimeter);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    void testIfAdditionOf200CentimeterAnd1KilometerEquals1002Meter() throws InValidQuantityValueException {
        Length twoHundredCentimeter = new Length(200, QuantityType.Length.CENTIMETER);
        Length oneKilometer = new Length(1, QuantityType.Length.KILOMETER);
        Length expectedSum = new Length(1002, QuantityType.Length.METER);

        Length actualSum = twoHundredCentimeter.add(oneKilometer);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    void testIfAdditionOf1MeterAnd100CentimeterNotEquals1Meter() throws InValidQuantityValueException {
        Length oneMeter = new Length(1, QuantityType.Length.METER);
        Length hundredCentimeter = new Length(100, QuantityType.Length.CENTIMETER);
        Length expectedSum = new Length(1, QuantityType.Length.METER);

        Length actualSum = oneMeter.add(hundredCentimeter);

        assertNotEquals(expectedSum, actualSum);
    }

    @Test
    void testIfSubtractionOf1MeterAnd50CentimeterEquals0_5Meter() throws InValidQuantityValueException, NegativeSubtractionException {
        Length oneMeter = new Length(1, QuantityType.Length.METER);
        Length centimeter0_5 = new Length(50, QuantityType.Length.CENTIMETER);
        Length expectedDifference = new Length(0.5, QuantityType.Length.METER);

        Length actualDifference = oneMeter.subtract(centimeter0_5);

        assertEquals(expectedDifference, actualDifference);
    }

    @Test
    void testIfSubtractionOf2000CentimeterAnd1MeterEquals19Meter() throws InValidQuantityValueException, NegativeSubtractionException {
        Length twoThousandCentimeter = new Length(2000, QuantityType.Length.CENTIMETER);
        Length oneMeter = new Length(1, QuantityType.Length.METER);
        Length expectedDifference = new Length(19, QuantityType.Length.METER);

        Length actualDifference = twoThousandCentimeter.subtract(oneMeter);

        assertEquals(expectedDifference, actualDifference);
    }

    @Test
    void testIfSubtractionOf3MeterAnd100CentimeterNotEquals1Meter() throws InValidQuantityValueException, NegativeSubtractionException {
        Length threeMeter = new Length(3, QuantityType.Length.METER);
        Length hundredCentimeter = new Length(100, QuantityType.Length.CENTIMETER);
        Length expectedDifference = new Length(1, QuantityType.Length.METER);

        Length actualDifference = threeMeter.subtract(hundredCentimeter);

        assertNotEquals(expectedDifference, actualDifference);
    }

    @Test
    void testThrowsExceptionIfGreaterQuantitySubtractedFromSmallerQuantity() throws InValidQuantityValueException {
        Length largerQuantity = new Length(2, QuantityType.Length.KILOMETER);
        Length smallerQuantity = new Length(1, QuantityType.Length.METER);

        assertThrows(NegativeSubtractionException.class, () -> smallerQuantity.subtract(largerQuantity));
    }
}