package Vehicle;

public class SuperCar extends Car {
    private int horsePower;
    private int maxSpeed;

    public SuperCar(int carId, String brandName, int modelYear, String color, String licensePlate, int horsePower, int maxSpeed) {
        super(carId, brandName, modelYear, color, licensePlate);
        this.horsePower = horsePower;
        this.maxSpeed = maxSpeed;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
