package Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Van extends Car {
    public Van(int carId, String brandName, String modelName, int releaseYear, String licensePlate, double price, String typeOfCar, boolean isAvailable, int ownerId) {
        super(carId, brandName, modelName, releaseYear, licensePlate, price, typeOfCar, isAvailable, ownerId);
    }

    public Van(int carId, Scanner in) {
        super(carId, in);
    }

    public Van(int carId, ResultSet rs) throws ParseException, SQLException {
        super(carId, rs);
    }
}
