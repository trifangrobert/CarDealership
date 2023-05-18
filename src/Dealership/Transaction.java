package Dealership;

public class Transaction {
    private int transactionId;
    private int carId;
    private int clientId;
    private String date;
    private double price;

    public Transaction(int transactionId, int carId, int clientId, String date, double price) {
        this.transactionId = transactionId;
        this.carId = carId;
        this.clientId = clientId;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
