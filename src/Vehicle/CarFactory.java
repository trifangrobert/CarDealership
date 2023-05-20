package Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
public class CarFactory {
    private static int uniqueId = 0;
    public void setUniqueId(int uniqueId) {
        CarFactory.uniqueId = uniqueId;
    }
    public Car createCar(Scanner in) throws ParseException {
        return new Car(uniqueId++, in);
    }

    public Car createCar(int carId, String licensePlate, boolean isAvailable, int ownerId, Scanner in) throws ParseException {
        return new Car(carId, licensePlate, isAvailable, ownerId, in);
    }

    public Car createCar(ResultSet rs) throws ParseException, SQLException {
        return new Car(uniqueId++, rs);
    }

    public Car createCar(int carId, ResultSet rs) throws ParseException, SQLException {
        if (rs.getString("type_of_car").equals("supercar")) {
            return new SuperCar(carId, rs);
        }
        else if (rs.getString("type_of_car").equals("van")) {
            return new Van(carId, rs);
        }
        else if (rs.getString("type_of_car").equals("suv")) {
            return new SUV(carId, rs);
        }
        return null;
    }

}
