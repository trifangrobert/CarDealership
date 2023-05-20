package Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class SuperCar extends Car {
    public SuperCar(int carId, String brandName, String modelName, int releaseYear, String licensePlate, double price, String typeOfCar, boolean isAvailable, int ownerId) {
        super(carId, brandName, modelName, releaseYear, licensePlate, price, typeOfCar, isAvailable, ownerId);
    }

    public SuperCar(int carId, Scanner in) {
        super(carId, in);
    }

    public SuperCar(int carId, ResultSet rs) throws ParseException, SQLException {
        super(carId, rs);
    }
}
