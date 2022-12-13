public class Temperature {
    double temp;
    TemperatureType type;

    public Temperature(double temp, TemperatureType type) {
        this.temp = temp;
        this.type = type;
    }

    public Temperature() {
    }


    public double convert(TemperatureType to) {
        double inKelvin = this.type.toKelvin(this.temp);
        return to.fromKelvin(inKelvin);
    }



}
