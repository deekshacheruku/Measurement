package quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TemperatureTest {
    @Test
    void testIf0CelsiusEquals32Fahrenheit() {
        Temperature zeroCelsius = new Temperature(0,QuantityType.Temperature.CELSIUS);
        Temperature thirtyTwoFahrenheit = new Temperature(32, QuantityType.Temperature.FAHRENHEIT);

        assertEquals(zeroCelsius,thirtyTwoFahrenheit);
    }

    @Test
    void testIf0CelsiusEquals273_15Kelvin() {
        Temperature zeroCelsius = new Temperature(0,QuantityType.Temperature.CELSIUS);
        Temperature kelvin273_15 = new Temperature(273.15, QuantityType.Temperature.KELVIN);

        assertEquals(zeroCelsius,kelvin273_15);
    }

    @Test
    void testIf1CelsiusNotEquals273Kelvin() {
        Temperature oneCelsius = new Temperature(1,QuantityType.Temperature.CELSIUS);
        Temperature twoSevenThreeKelvin = new Temperature(273, QuantityType.Temperature.KELVIN);

        assertNotEquals(oneCelsius,twoSevenThreeKelvin);
    }
}
