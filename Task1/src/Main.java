public class Main {
    public static void main(String[] args) {
        Temperature cel = new Temperature(60, TemperatureType.CELSIUS);
        System.out.println("Initial temperature in Celsius: " + cel.temp + "C");
        System.out.println("Temperature in Fahrenheit: " + cel.convert(TemperatureType.FAHRENHEIT) + "F");
        System.out.println("Temperature in Kelvin: " + cel.convert(TemperatureType.KELVIN) + "K");

    }
}
