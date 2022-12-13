public class TemperatureFactory {
    public Temperature getTemperature(TemperatureType type) throws IllegalAccessException {
        Temperature toReturn = null;
        switch (type) {
            case CELSIUS:
                toReturn = new Celsius();
                break;
            case FAHRENHEIT:
                toReturn = new Fahrenheit();
                break;
            case KELVIN:
                toReturn = new Kelvin();
                break;
            default:
                throw new IllegalAccessException("Wrong type");
        }
        return toReturn;
    }
}
