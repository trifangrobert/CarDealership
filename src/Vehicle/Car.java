package Vehicle;

import java.util.*;

public class Car {
    protected final int carId;
    protected String brandName;
    protected int modelYear;
    protected String color;
    protected String licensePlate;
    static private final Set<String> licensePlates = new HashSet<String>();
    protected Car(int carId, String brandName, int modelYear, String color, String licensePlate) {
        this.carId = carId;
        this.brandName = brandName;
        this.modelYear = modelYear;
        this.color = color;
        this.licensePlate = licensePlate;
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
}
