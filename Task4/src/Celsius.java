public class Celsius implements Temperature {
    double celsius;

    public Celsius() {

    }

    public Celsius(double celsius) {
        this.celsius = celsius;
    }


//    public double convertTo(Temperature2 t) {
//        return 0;
//    }
//    public double toFarenheit() {
//        return (this.celsius * 9/5) + 32;
//    }
//    public double toKelvin() {
//        return this.celsius + 273.15;
//    }

    @Override
    public double getKelvin(double temp) {
        return temp + 273.15;
    }

    @Override
    public double getFahrenheit(double temp) {
        return (temp * 9/5) + 32;
    }

    @Override
    public double getCelsius(double temp) {
        return temp;
    }
}
