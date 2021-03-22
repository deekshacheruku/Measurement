package quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LengthTest {
    @Test
    void testIs1CentimeterEquals1Centimeter() throws InValidQuantityValueException {
        Length firstQuantity = new Length(1, Length.LengthType.CENTIMETER);
        Length secondQuantity = new Length(1, Length.LengthType.CENTIMETER);

        assertEquals(secondQuantity, firstQuantity);
    }

    @Test
    void testIs1CentimeterNotEquals2Centimeter() throws InValidQuantityValueException {
        Length firstQuantity = new Length(1, Length.LengthType.CENTIMETER);
        Length secondQuantity = new Length(2, Length.LengthType.CENTIMETER);

        assertNotEquals(secondQuantity, firstQuantity);
    }

    @Test
    void testThrowsExceptionWhenQuantityValueIsZero() {
        assertThrows(InValidQuantityValueException.class, () -> new Length(0, Length.LengthType.CENTIMETER));
    }

    @Test
    void testThrowsExceptionWhenQuantityValueIsNegative() {
        assertThrows(InValidQuantityValueException.class, () -> new Length(-1, Length.LengthType.CENTIMETER));
    }

    @Test
    void testIf1MeterEquals100Centimeter() throws InValidQuantityValueException {
        Length meter1 = new Length(1, Length.LengthType.METER);
        Length centimeter100 = new Length(100, Length.LengthType.CENTIMETER);

        assertEquals(centimeter100, meter1);
    }

    @Test
    void testIf2MetersNotEquals100Centimeter() throws InValidQuantityValueException {
        Length meters2 = new Length(2, Length.LengthType.METER);
        Length centimeter100 = new Length(100, Length.LengthType.CENTIMETER);

        assertNotEquals(centimeter100, meters2);
    }

    @Test
    void test100CentimeterEquals0_001Kilometer() throws InValidQuantityValueException {
        Length centimeters100 = new Length(100, Length.LengthType.CENTIMETER);
        Length kilometers0_001 = new Length(0.001, Length.LengthType.KILOMETER);

        assertEquals(kilometers0_001, centimeters100);
    }

    @Test
    void test1000CentimeterNotEquals0_001Kilometer() throws InValidQuantityValueException {
        Length kilometer0_001 = new Length(0.001, Length.LengthType.KILOMETER);
        Length centimeter1000 = new Length(1000, Length.LengthType.CENTIMETER);

        assertNotEquals(kilometer0_001, centimeter1000);
    }

    @Test
    void testIfAdditionOf1MeterAnd100CentimeterEquals2Meter() throws InValidQuantityValueException {
        Length meter1 = new Length(1, Length.LengthType.METER);
        Length centimeter100 = new Length(100, Length.LengthType.CENTIMETER);
        Length expectedSum = new Length(2, Length.LengthType.METER);

        Length actualSum = meter1.add(centimeter100);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    void testIfAdditionOf200CentimeterAnd1KilometerEquals1002Meter() throws InValidQuantityValueException {
        Length centimeter200 = new Length(200, Length.LengthType.CENTIMETER);
        Length kilometer1 = new Length(1, Length.LengthType.KILOMETER);
        Length expectedSum = new Length(1002, Length.LengthType.METER);

        Length actualSum = centimeter200.add(kilometer1);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    void testIfAdditionOf1MeterAnd100CentimeterNotEquals1Meter() throws InValidQuantityValueException {
        Length meter1 = new Length(1, Length.LengthType.METER);
        Length centimeter100 = new Length(100, Length.LengthType.CENTIMETER);
        Length expectedSum = new Length(1, Length.LengthType.METER);

        Length actualSum = meter1.add(centimeter100);

        assertNotEquals(expectedSum, actualSum);
    }

    @Test
    void testIfSubtractionOf1MeterAnd50CentimeterEquals0_5Meter() throws InValidQuantityValueException, NegativeSubtractionException {
        Length meter1 = new Length(1, Length.LengthType.METER);
        Length centimeter0_5 = new Length(50, Length.LengthType.CENTIMETER);
        Length expectedDifference = new Length(0.5, Length.LengthType.METER);

        Length actualDifference = meter1.subtract(centimeter0_5);

        assertEquals(expectedDifference, actualDifference);
    }

    @Test
    void testIfSubtractionOf2000CentimeterAnd1MeterEquals19Meter() throws InValidQuantityValueException, NegativeSubtractionException {
        Length centimeter2000 = new Length(2000, Length.LengthType.CENTIMETER);
        Length meter1 = new Length(1, Length.LengthType.METER);
        Length expectedDifference = new Length(19, Length.LengthType.METER);

        Length actualDifference = centimeter2000.subtract(meter1);

        assertEquals(expectedDifference, actualDifference);
    }

    @Test
    void testIfSubtractionOf3MeterAnd100CentimeterNotEquals1Meter() throws InValidQuantityValueException, NegativeSubtractionException {
        Length meter3 = new Length(3, Length.LengthType.METER);
        Length centimeter100 = new Length(100, Length.LengthType.CENTIMETER);
        Length expectedDifference = new Length(1, Length.LengthType.METER);

        Length actualDifference = meter3.subtract(centimeter100);

        assertNotEquals(expectedDifference, actualDifference);
    }

    @Test
    void testThrowsExceptionIfGreaterQuantitySubtractedFromSmallerQuantity() throws InValidQuantityValueException {
        Length largerQuantity = new Length(2, Length.LengthType.KILOMETER);
        Length smallerQuantity = new Length(1, Length.LengthType.METER);

        assertThrows(NegativeSubtractionException.class, () -> smallerQuantity.subtract(largerQuantity));
    }
}