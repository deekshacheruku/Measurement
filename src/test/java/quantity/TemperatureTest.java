package quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TemperatureTest {
    @Test
    void testIf0CelsiusEquals32Fahrenheit() {
        Temperature celsius0 = new Temperature(0,QuantityType.Temperature.CELSIUS);
        Temperature fahrenheit32 = new Temperature(32, QuantityType.Temperature.FAHRENHEIT);

        assertEquals(celsius0,fahrenheit32);
    }

    @Test
    void testIf0CelsiusEquals273_15Kelvin() {
        Temperature celsius0 = new Temperature(0,QuantityType.Temperature.CELSIUS);
        Temperature kelvin273_15 = new Temperature(273.15, QuantityType.Temperature.KELVIN);

        assertEquals(celsius0,kelvin273_15);
    }

    @Test
    void testIf1CelsiusNotEquals273Kelvin() {
        Temperature celsius1 = new Temperature(1,QuantityType.Temperature.CELSIUS);
        Temperature kelvin273 = new Temperature(273, QuantityType.Temperature.KELVIN);

        assertNotEquals(celsius1,kelvin273);
    }
}
