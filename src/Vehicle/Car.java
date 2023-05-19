package Vehicle;

import java.util.*;

public class Car {
    protected final int carId;
    protected String brandName;
    protected int modelYear;
    protected String color;
    protected String licensePlate;
    protected double price;

    static public int nextCarId = 1;
    static public boolean isLicensePlateUnique(String licensePlate) {
        return !licensePlates.contains(licensePlate);
    }
    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brandName='" + brandName + '\'' +
                ", modelYear=" + modelYear +
                ", color='" + color + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }

    static private final Set<String> licensePlates = new HashSet<String>();

    public Car(String brandName, int modelYear, String color, String licensePlate, double price) {
        this.carId = nextCarId++;
        this.brandName = brandName;
        this.modelYear = modelYear;
        this.color = color;

        this.price = price;
        String lp = generateLicensePlate();
        while (!isLicensePlateUnique(lp)) {
            lp = generateLicensePlate();
        }
        this.licensePlate = lp;
    }

    public String generateLicensePlate() {
        Random random = new Random();
        String licensePlate = "";
        for (int i = 0; i < 3; i++) {
            licensePlate += (char) (random.nextInt(26) + 'A');
        }
        for (int i = 0; i < 3; i++) {
            licensePlate += (char) (random.nextInt(10) + '0');
        }
        return licensePlate;

    }

    public int getCarId() {
        return carId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
