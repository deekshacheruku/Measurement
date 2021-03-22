package quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TemperatureTest {
    @Test
    void testIf0CelsiusEquals32Fahrenheit() {
        Temperature celsius0 = new Temperature(0, QuantityType.TemperatureType.CELSIUS);
        Temperature fahrenheit32 = new Temperature(32, QuantityType.TemperatureType.FAHRENHEIT);

        assertEquals(celsius0, fahrenheit32);
    }

    @Test
    void testIf0CelsiusEquals273_15Kelvin() {
        Temperature celsius0 = new Temperature(0, QuantityType.TemperatureType.CELSIUS);
        Temperature kelvin273_15 = new Temperature(273.15, QuantityType.TemperatureType.KELVIN);

        assertEquals(celsius0, kelvin273_15);
    }

    @Test
    void testIf1CelsiusNotEquals273Kelvin() {
        Temperature celsius1 = new Temperature(1, QuantityType.TemperatureType.CELSIUS);
        Temperature kelvin273 = new Temperature(273, QuantityType.TemperatureType.KELVIN);

        assertNotEquals(celsius1, kelvin273);
    }
}
