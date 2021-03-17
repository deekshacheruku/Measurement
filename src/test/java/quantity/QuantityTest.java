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
        Quantity quantityInMeters = new Quantity(1,QuantityType.METER);
        Quantity quantityInCentimeter = new Quantity(100,QuantityType.CENTIMETER);

        boolean actualResult =  quantityInMeters.equals(quantityInCentimeter);

        assertTrue(actualResult);
    }

    @Test
    void testIf2MetersNotEquals100Centimeter() throws InValidQuantityValueException {
        Quantity quantityInMeters = new Quantity(2,QuantityType.METER);
        Quantity quantityInCentimeter = new Quantity(100,QuantityType.CENTIMETER);

        boolean actualResult =  quantityInMeters.equals(quantityInCentimeter);

        assertFalse(actualResult);
    }

    @Test
    void test100CentimeterEquals0_001Kilometer() throws InValidQuantityValueException {
        Quantity quantityInCentimeters = new Quantity(100,QuantityType.CENTIMETER);
        Quantity quantityInKilometers = new Quantity(0.001,QuantityType.KILOMETER);

        boolean actualResult = quantityInCentimeters.equals(quantityInKilometers);

        assertTrue(actualResult);
    }

    @Test
    void test1000CentimeterNotEquals0_001Kilometer() throws InValidQuantityValueException {
        Quantity quantityInKilometer = new Quantity(0.001,QuantityType.KILOMETER);
        Quantity quantityInCentimeter = new Quantity(1000,QuantityType.CENTIMETER);

        boolean actualResult =  quantityInCentimeter.equals(quantityInKilometer);

        assertFalse(actualResult);
    }
}