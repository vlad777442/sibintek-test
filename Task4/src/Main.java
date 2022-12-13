public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        TemperatureFactory factory = new TemperatureFactory();

        Temperature celsius = factory.getTemperature(TemperatureType.CELSIUS);
        Temperature fahrenheit = factory.getTemperature(TemperatureType.FAHRENHEIT);
        Temperature kelvin = factory.getTemperature(TemperatureType.FAHRENHEIT);

        System.out.println(celsius.getFahrenheit(10) + "F");
        System.out.println(celsius.getKelvin(50) + "K");

    }
}
