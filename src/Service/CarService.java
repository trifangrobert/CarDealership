package Service;

import Client.Client;
import Dealership.CarDealership;
import Dealership.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private List<Client> clients = new ArrayList<>();
    private List<CarDealership> dealerships = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    public void addDealership(CarDealership dealership) {
        dealerships.add(dealership);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<CarDealership> getDealerships() {
        return dealerships;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }



}
