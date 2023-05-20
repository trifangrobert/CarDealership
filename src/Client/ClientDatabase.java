package Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ClientDatabase {
    private static ClientDatabase instance = null;
    Connection connection;
    ClientFactory clientFactory = new ClientFactory();
    private ClientDatabase() {}
    public static ClientDatabase getInstance() {
        if (instance == null) {
            instance = new ClientDatabase();
        }
        return instance;
    }
    public static void setConnection(Connection connection) {
        instance.connection = connection;
    }


    public static List<Client> read() {
        List<Client> clients = new ArrayList<>();
        try {
            Statement statement = instance.connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM clients");
            while (rs.next()) {
                Client curr = instance.clientFactory.createClient(rs.getInt("client_id"), rs);
                clients.add(curr);
            }
            statement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return clients;
    }
    public static void create(Client client) {
        try {
            String query = "INSERT INTO clients (client_id, first_name, last_name, birthdate, money, street, city, state, zip) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = instance.connection.prepareStatement(query);
            preparedStatement.setInt(1, client.getClientId());
            preparedStatement.setString(2, client.getFirstName());
            preparedStatement.setString(3, client.getLastName());
            preparedStatement.setDate(4, new Date(client.getBirthDate().getTime()));
            preparedStatement.setDouble(5, client.getMoney());
            preparedStatement.setString(6, client.getAddress().getStreet());
            preparedStatement.setString(7, client.getAddress().getCity());
            preparedStatement.setString(8, client.getAddress().getState());
            preparedStatement.setInt(9, client.getAddress().getZip());
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void update(Client newClient) {
        try {
            String query = "UPDATE clients SET first_name = ?, last_name = ?, birthdate = ?, money = ?, street = ?, city = ?, state = ?, zip = ? WHERE client_id = ?";
            PreparedStatement preparedStatement = instance.connection.prepareStatement(query);
            preparedStatement.setString(1, newClient.getFirstName());
            preparedStatement.setString(2, newClient.getLastName());
            preparedStatement.setDate(3, new Date(newClient.getBirthDate().getTime()));
            preparedStatement.setDouble(4, newClient.getMoney());
            preparedStatement.setString(5, newClient.getAddress().getStreet());
            preparedStatement.setString(6, newClient.getAddress().getCity());
            preparedStatement.setString(7, newClient.getAddress().getState());
            preparedStatement.setInt(8, newClient.getAddress().getZip());
            preparedStatement.setInt(9, newClient.getClientId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void delete(int clientId) {
        try {
            String query = "DELETE FROM clients WHERE client_id = ?";
            PreparedStatement preparedStatement = instance.connection.prepareStatement(query);
            preparedStatement.setInt(1, clientId);
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
            ResultSet rs = statement.executeQuery("SELECT MAX(client_id) FROM clients");
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
