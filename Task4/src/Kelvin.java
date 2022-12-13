public class Kelvin implements Temperature {
    public Kelvin() {
    }

    @Override
    public double getKelvin(double temp) {
        return temp;
    }

    @Override
    public double getFahrenheit(double temp) {
        return 0;
    }

    @Override
    public double getCelsius(double temp) {
        return temp - 273.15;
    }
}
