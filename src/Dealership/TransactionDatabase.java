package Dealership;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class TransactionDatabase {
    private static TransactionDatabase instance = null;
    Connection connection;

    TransactionFactory transactionFactory = new TransactionFactory();
    private TransactionDatabase() {
    }
    public static TransactionDatabase getInstance() {
        if (instance == null) {
            instance = new TransactionDatabase();
        }
        return instance;
    }

    public static void setConnection(Connection connection) {
        instance.connection = connection;
    }
    public static int getMaxId() {
        int maxId = -1;
        try {
            Statement statement = instance.connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT MAX(transaction_id) FROM transactions");
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

    public static List<Transaction> read() {
        List<Transaction> transactions = new ArrayList<>();
        try {
            Statement statement = instance.connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM transactions");
            while (rs.next()) {
                Transaction curr = instance.transactionFactory.createTransaction(rs.getInt("transaction_id"), rs);
                transactions.add(curr);
            }
            statement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return transactions;
    }

    public static void create(Transaction transaction) {
        try {
            String query = "INSERT INTO transactions (transaction_id, car_id, client_id, dealership_id, transaction_date) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = instance.connection.prepareStatement(query);
            preparedStatement.setInt(1, transaction.getTransactionId());
            preparedStatement.setInt(2, transaction.getCarId());
            preparedStatement.setInt(3, transaction.getClientId());
            preparedStatement.setInt(4, transaction.getDealershipId());
            preparedStatement.setDate(5, new Date(transaction.getTransactionDate().getTime()));
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void update(Transaction newTransaction) {
        try {
            String query = "UPDATE transactions SET car_id = ?, client_id = ?, dealership_id = ? WHERE transaction_id = ?";
            PreparedStatement preparedStatement = instance.connection.prepareStatement(query);
            preparedStatement.setInt(1, newTransaction.getCarId());
            preparedStatement.setInt(2, newTransaction.getClientId());
            preparedStatement.setInt(3, newTransaction.getDealershipId());
            preparedStatement.setInt(4, newTransaction.getTransactionId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int transactionId) {
        try {
            String query = "DELETE FROM transactions WHERE transaction_id = ?";
            PreparedStatement preparedStatement = instance.connection.prepareStatement(query);
            preparedStatement.setInt(1, transactionId);
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
