package Dealership;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
public class Transaction {
    private int transactionId;
    private int carId;
    private int clientId;
    private int dealershipId;
    private Date transactionDate;

    public Transaction(int transactionId, int carId, int clientId, int dealershipId, Date transactionDate) {
        this.transactionId = transactionId;
        this.carId = carId;
        this.clientId = clientId;
        this.dealershipId = dealershipId;
        this.transactionDate = transactionDate;
    }

    public Transaction(int transactionId, int carId, int clientId, int dealershipId) {
        this.transactionId = transactionId;
        this.carId = carId;
        this.clientId = clientId;
        this.dealershipId = dealershipId;
        Date now = new Date();
        this.transactionDate = now;
    }

    public Transaction(int transactionId, ResultSet rs)throws SQLException {
        this.transactionId = transactionId;
        this.carId = rs.getInt("car_id");
        this.clientId = rs.getInt("client_id");
        this.dealershipId = rs.getInt("dealership_id");
        this.transactionDate = rs.getDate("transaction_date");
    }
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getDealershipId() {
        return dealershipId;
    }

    public void setDealershipId(int dealershipId) {
        this.dealershipId = dealershipId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", carId=" + carId +
                ", clientId=" + clientId +
                ", dealershipId=" + dealershipId +
                ", transactionDate=" + transactionDate.toString() +
                '}';
    }
}