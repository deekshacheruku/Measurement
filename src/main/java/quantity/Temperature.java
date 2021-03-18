package quantity;

public class Temperature {
    private final double value;
    private final QuantityType.Temperature temperatureType;

    public Temperature(double value, QuantityType.Temperature temperatureType) {
        this.value = value;
        this.temperatureType = temperatureType;
    }

    private double convertTemperatureValueIntoCelsius(Temperature temperature){
        if(temperature.temperatureType.name().equals("FAHRENHEIT"))
            return ((temperature.value - 32)*5)/9;
        else if (temperature.temperatureType.name().equals("KELVIN"))
            return temperature.value - 273.15;
        return temperature.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temperature temperature = (Temperature) o;
        return convertTemperatureValueIntoCelsius(this) == convertTemperatureValueIntoCelsius(temperature);
    }
}
