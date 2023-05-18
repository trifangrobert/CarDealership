package Vehicle;

public class SUV extends Car {
    private double engineSize;
    private double consumption;

    public SUV(int carId, String brandName, int modelYear, String color, String licensePlate, double engineSize, double consumption) {
        super(carId, brandName, modelYear, color, licensePlate);
        this.engineSize = engineSize;
        this.consumption = consumption;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }
}