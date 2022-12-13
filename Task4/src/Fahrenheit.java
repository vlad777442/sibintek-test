public class Fahrenheit implements Temperature {
    public Fahrenheit() {
    }


    @Override
    public double getKelvin(double temp) {
        return (temp - 32) * 5/9 + 273.15;
    }

    @Override
    public double getFahrenheit(double temp) {
        return temp;
    }

    @Override
    public double getCelsius(double temp) {
        return (temp - 32) * 5/9;
    }
}
