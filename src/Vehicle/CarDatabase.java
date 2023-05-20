package Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDatabase {
    private static CarDatabase instance = null;
    Connection connection = null;
    CarFactory carFactory = new CarFactory();
    private CarDatabase() {}
    public static CarDatabase getInstance() {
        if (instance == null) {
            instance = new CarDatabase();
        }
        return instance;
    }
    public static void setConnection(Connection connection) {
        instance.connection = connection;
    }

    public static List<Car> read() {
        List<Car> cars = new ArrayList<>();
        try {
            Statement statement = instance.connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM cars");
            while (rs.next()) {
                Car curr = instance.carFactory.createCar(rs.getInt("car_id"), rs);
                cars.add(curr);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cars;
    }

    public static void create(Car car) {
        try {
            String query = "INSERT INTO cars (car_id, brand_name, model_name, release_year, license_plate, price, type_of_car, is_available, owner_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = instance.connection.prepareStatement(query);
            preparedStatement.setInt(1, car.getCarId());
            preparedStatement.setString(2, car.getBrandName());
            preparedStatement.setString(3, car.getModelName());
            preparedStatement.setInt(4, car.getReleaseYear());
            preparedStatement.setString(5, car.getLicensePlate());
            preparedStatement.setDouble(6, car.getPrice());
            preparedStatement.setString(7, car.getTypeOfCar());
            preparedStatement.setBoolean(8, car.getIsAvailable());
            preparedStatement.setInt(9, car.getOwnerId());
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void update(Car newCar) {
        try {
            String query = "UPDATE cars SET brand_name = ?, model_name = ?, release_year = ?, license_plate = ?, price = ?, type_of_car = ?, is_available = ?, owner_id = ? WHERE car_id = ?";
            PreparedStatement preparedStatement = instance.connection.prepareStatement(query);
            preparedStatement.setString(1, newCar.getBrandName());
            preparedStatement.setString(2, newCar.getModelName());
            preparedStatement.setInt(3, newCar.getReleaseYear());
            preparedStatement.setString(4, newCar.getLicensePlate());
            preparedStatement.setDouble(5, newCar.getPrice());
            preparedStatement.setString(6, newCar.getTypeOfCar());
            preparedStatement.setBoolean(7, newCar.getIsAvailable());
            preparedStatement.setInt(8, newCar.getOwnerId());
            preparedStatement.setInt(9, newCar.getCarId());
            preparedStatement.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int carId) {
        try {
            String query = "DELETE FROM cars WHERE car_id = ?";
            PreparedStatement preparedStatement = instance.connection.prepareStatement(query);
            preparedStatement.setInt(1, carId);
            preparedStatement.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static int getMaxId() {
        int maxId = -1;
        try {
            Statement statement = instance.connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT MAX(car_id) FROM cars");
            while (rs.next()) {
                maxId = rs.getInt(1);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return maxId;
    }
}
