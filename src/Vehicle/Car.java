package Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Car {
    protected final int carId;
    protected String brandName;
    protected String modelName;
    protected int releaseYear;
    protected String licensePlate;
    protected double price;
    protected String typeOfCar;
    boolean isAvailable;
    protected int ownerId;

    public Car(int carId, String brandName, String modelName, int releaseYear, String licensePlate, double price, String typeOfCar, boolean isAvailable, int ownerId) {
        this.carId = carId;
        this.brandName = brandName;
        this.modelName = modelName;
        this.releaseYear = releaseYear;
        this.licensePlate = licensePlate;
        this.price = price;
        this.typeOfCar = typeOfCar;
        this.isAvailable = isAvailable;
        this.ownerId = ownerId;
    }
    public Car(int carId, Scanner in) {
        this.carId = carId;
        this.read(in);
    }
    public Car(int carId, String licensePlate, boolean isAvailable, int ownerId, Scanner in) {
        this.carId = carId;
        this.licensePlate = licensePlate;
        this.isAvailable = isAvailable;
        this.ownerId = ownerId;
        System.out.print("Enter brand name: ");
        this.brandName = in.nextLine();
        System.out.print("Enter model name: ");
        this.modelName  = in.nextLine();
        System.out.print("Enter release year: ");
        this.releaseYear = in.nextInt();
        in.nextLine();
        System.out.print("Enter price: ");
        this.price = in.nextDouble();
        in.nextLine();
        System.out.print("Enter type of car: ");
        this.typeOfCar = in.nextLine();
    }
    public void read(Scanner in) {
        System.out.print("Enter brand name: ");
        this.brandName = in.nextLine();
        System.out.print("Enter model name: ");
        this.modelName  = in.nextLine();
        System.out.print("Enter release year: ");
        this.releaseYear = in.nextInt();
        in.nextLine();
        String lp = generateLicensePlate();
        while (!isLicensePlateUnique(lp)) {
            lp = generateLicensePlate();
        }
        this.licensePlate = lp;
        System.out.print("Enter price: ");
        this.price = in.nextDouble();
        in.nextLine();
        System.out.print("Enter type of car: ");
        this.typeOfCar = in.nextLine();
        this.isAvailable = true;
        System.out.println("Enter dealership id: ");
        this.ownerId = in.nextInt();
        in.nextLine();
    }

    public Car(int carId, ResultSet rs) throws SQLException {
        this.carId = carId;
        this.read(rs);
    }

    public void read(ResultSet rs) throws SQLException {
        this.brandName = rs.getString("brand_name");
        this.modelName = rs.getString("model_name");
        this.releaseYear = rs.getInt("release_year");
        this.licensePlate = rs.getString("license_plate");
        this.price = rs.getDouble("price");
        this.typeOfCar = rs.getString("type_of_car");
        this.isAvailable = rs.getBoolean("is_available");
        this.ownerId = rs.getInt("owner_id");
    }
    static public boolean isLicensePlateUnique(String licensePlate) {
        return !licensePlates.contains(licensePlate);
    }
    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brandName='" + brandName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", releaseYear=" + releaseYear +
                ", licensePlate='" + licensePlate + '\'' +
                ", price=" + price +
                ", typeOfCar='" + typeOfCar + '\'' +
                ", isAvailable=" + isAvailable +
                ", ownerId=" + ownerId +
                '}';
    }

    static private final Set<String> licensePlates = new HashSet<>();

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

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
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

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
