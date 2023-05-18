package Vehicle;

public class Van extends Car {
    private int numberOfSeats;
    private int spaceCapacity;

    public Van(int carId, String brandName, int modelYear, String color, String licensePlate, int numberOfSeats, int spaceCapacity) {
        super(carId, brandName, modelYear, color, licensePlate);
        this.numberOfSeats = numberOfSeats;
        this.spaceCapacity = spaceCapacity;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getSpaceCapacity() {
        return spaceCapacity;
    }

    public void setSpaceCapacity(int spaceCapacity) {
        this.spaceCapacity = spaceCapacity;
    }
}
