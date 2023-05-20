package Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class SUV extends Car {
    public SUV(int carId, String brandName, String modelName, int releaseYear, String licensePlate, double price, String typeOfCar, boolean isAvailable, int ownerId) {
        super(carId, brandName, modelName, releaseYear, licensePlate, price, typeOfCar, isAvailable, ownerId);
    }

    public SUV(int carId, Scanner in) {
        super(carId, in);
    }

    public SUV(int carId, ResultSet rs) throws ParseException, SQLException {
        super(carId, rs);
    }
}