// Реализовано с помощью Enum, этот класс не задействован
public class TemperatureConverter {
    public static double celsiusToFarenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double farenheitToCelsius(double farenheit) {
        return (farenheit - 32) * 5/9;
    }

    public static double farenheitToKelvin(double farenheit) {
        return (farenheit - 32) * 5/9 + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double kelvinToFarenheit(double kelvin) {
        return (kelvin - 273.15) * 9/5 + 32;
    }
}
