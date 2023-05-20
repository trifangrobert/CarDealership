package Dealership;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DealershipDatabase {
    private static DealershipDatabase instance = null;
    Connection connection;
    DealershipFactory dealershipFactory = new DealershipFactory();
    private DealershipDatabase() {}
    public static DealershipDatabase getInstance() {
        if (instance == null) {
            instance = new DealershipDatabase();
        }
        return instance;
    }
    public static void setConnection(Connection connection) {
        instance.connection = connection;
    }

    public static List<Dealership> read() {
        List<Dealership> dealerships = new ArrayList<>();
        try {
            Statement statement = instance.connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM dealerships");
            while (rs.next()) {
                Dealership curr = instance.dealershipFactory.createDealership(rs.getInt("dealership_id"), rs);
                System.out.println(curr);
                dealerships.add(curr);
            }
            statement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dealerships;
    }
    public static void create(Dealership dealership) {
        try {
            String query = "INSERT INTO dealerships (dealership_id, dealer_name, city, website) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = instance.connection.prepareStatement(query);
            preparedStatement.setInt(1, dealership.getDealershipId());
            preparedStatement.setString(2, dealership.getDealerName());
            preparedStatement.setString(3, dealership.getCity());
            preparedStatement.setString(4, dealership.getWebsite());
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void update(Dealership newDealership) {
        try {
            String query = "UPDATE dealerships SET dealer_name = ?, city = ?, website = ? WHERE dealership_id = ?";
            PreparedStatement preparedStatement = instance.connection.prepareStatement(query);
            preparedStatement.setString(1, newDealership.getDealerName());
            preparedStatement.setString(2, newDealership.getCity());
            preparedStatement.setString(3, newDealership.getWebsite());
            preparedStatement.setInt(4, newDealership.getDealershipId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void delete(int dealershipId) {
        try {
            String query = "DELETE FROM dealerships WHERE dealership_id = ?";
            PreparedStatement preparedStatement = instance.connection.prepareStatement(query);
            preparedStatement.setInt(1, dealershipId);
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getMaxId() {
        int maxId = -1;
        try {
            Statement statement = instance.connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT MAX(dealership_id) FROM dealerships");
            while (rs.next()) {
                maxId = rs.getInt(1);
            }
            statement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return maxId;
    }
}
