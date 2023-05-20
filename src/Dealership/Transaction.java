package Dealership;

import java.util.Date;

public class Transaction {
    private int transactionId;
    private int carId;
    private int clientId;
    private int dealershipId;
    private Date date;
    private double price;

    public Transaction(int transactionId, int carId, int clientId, int dealershipId, Date date, double price) {
        this.transactionId = transactionId;
        this.carId = carId;
        this.clientId = clientId;
        this.dealershipId = dealershipId;
        this.date = date;
        this.price = price;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", carId=" + carId +
                ", clientId=" + clientId +
                ", dealershipId=" + dealershipId +
                ", date=" + date +
                ", price=" + price +
                '}';
    }
}
