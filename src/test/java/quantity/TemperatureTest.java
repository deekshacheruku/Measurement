package quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TemperatureTest {
    @Test
    void testIf0CelsiusEquals32Fahrenheit() {
        Temperature celsius0 = new Temperature(0, Temperature.TemperatureType.CELSIUS);
        Temperature fahrenheit32 = new Temperature(32, Temperature.TemperatureType.FAHRENHEIT);

        assertEquals(celsius0, fahrenheit32);
    }

    @Test
    void testIf0CelsiusEquals273_15Kelvin() {
        Temperature celsius0 = new Temperature(0, Temperature.TemperatureType.CELSIUS);
        Temperature kelvin273_15 = new Temperature(273.15, Temperature.TemperatureType.KELVIN);

        assertEquals(celsius0, kelvin273_15);
    }

    @Test
    void testIf1CelsiusNotEquals273Kelvin() {
        Temperature celsius1 = new Temperature(1, Temperature.TemperatureType.CELSIUS);
        Temperature kelvin273 = new Temperature(273, Temperature.TemperatureType.KELVIN);

        assertNotEquals(celsius1, kelvin273);
    }
}
