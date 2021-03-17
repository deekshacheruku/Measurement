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
        Quantity quantityInMeter = new Quantity(1, QuantityType.METER);
        Quantity quantityInCentimeter = new Quantity(100, QuantityType.CENTIMETER);
        Quantity expectedQuantityInMeter = new Quantity(2, QuantityType.METER);

        Quantity actualQuantityInMeter = quantityInMeter.add(quantityInCentimeter, QuantityType.METER);
        boolean actualResult = actualQuantityInMeter.equals(expectedQuantityInMeter);

        assertTrue(actualResult);
    }

    @Test
    void testIfAdditionOf200CentimeterAnd1KilometerEquals100200Centimeter() throws InValidQuantityValueException {
        Quantity quantityInCentimeter = new Quantity(200, QuantityType.CENTIMETER);
        Quantity quantityInKilometer = new Quantity(1, QuantityType.KILOMETER);
        Quantity expectedQuantityInCentimeter = new Quantity(100200, QuantityType.CENTIMETER);

        Quantity actualQuantityInMeter = quantityInCentimeter.add(quantityInKilometer, QuantityType.CENTIMETER);
        boolean actualResult = actualQuantityInMeter.equals(expectedQuantityInCentimeter);

        assertTrue(actualResult);
    }

    @Test
    void testIfAdditionOf1MeterAnd100CentimeterNotEquals1Meter() throws InValidQuantityValueException {
        Quantity quantityInMeter = new Quantity(1, QuantityType.METER);
        Quantity quantityInCentimeter = new Quantity(100, QuantityType.CENTIMETER);
        Quantity expectedQuantityInMeter = new Quantity(1, QuantityType.METER);

        Quantity actualQuantityInMeter = quantityInMeter.add(quantityInCentimeter, QuantityType.METER);
        boolean actualResult = actualQuantityInMeter.equals(expectedQuantityInMeter);

        assertFalse(actualResult);
    }

    @Test
    void testIfSubtractionOf1MeterAnd50CentimeterEquals0_5Meter() throws InValidQuantityValueException {
        Quantity quantityInMeter = new Quantity(1, QuantityType.METER);
        Quantity quantityInCentimeter = new Quantity(50, QuantityType.CENTIMETER);
        Quantity expectedQuantityInMeter = new Quantity(0.5, QuantityType.METER);

        Quantity actualQuantityInMeter = quantityInMeter.subtract(quantityInCentimeter, QuantityType.METER);
        boolean actualResult = actualQuantityInMeter.equals(expectedQuantityInMeter);

        assertTrue(actualResult);
    }

    @Test
    void testIfSubtractionOf2000CentimeterAnd1MeterEquals1900Centimeter() throws InValidQuantityValueException {
        Quantity quantityInCentimeter = new Quantity(2000, QuantityType.CENTIMETER);
        Quantity quantityInMeter = new Quantity(1, QuantityType.METER);
        Quantity expectedQuantityInCentimeter = new Quantity(1900, QuantityType.CENTIMETER);

        Quantity actualQuantityInMeter = quantityInCentimeter.subtract(quantityInMeter, QuantityType.CENTIMETER);
        boolean actualResult = actualQuantityInMeter.equals(expectedQuantityInCentimeter);

        assertTrue(actualResult);
    }

    @Test
    void testIfSubtractionOf3MeterAnd100CentimeterNotEquals1Meter() throws InValidQuantityValueException {
        Quantity quantityInMeter = new Quantity(3, QuantityType.METER);
        Quantity quantityInCentimeter = new Quantity(100, QuantityType.CENTIMETER);
        Quantity expectedQuantityInMeter = new Quantity(1, QuantityType.METER);

        Quantity actualQuantityInMeter = quantityInMeter.subtract(quantityInCentimeter, QuantityType.METER);
        boolean actualResult = actualQuantityInMeter.equals(expectedQuantityInMeter);

        assertFalse(actualResult);
    }
}