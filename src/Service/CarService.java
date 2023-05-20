package Service;

import Client.Client;
import Dealership.Dealership;
import Dealership.Transaction;
import Vehicle.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private List<Client> clients = new ArrayList<>();
    private List<Dealership> dealerships = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    public void addDealership(Dealership dealership) {
        dealerships.add(dealership);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void addCarToDealership(int dealershipId, Car car) {
        // get dealership from dealerships list
        int dealershipPos = -1;
        for (int i = 0; i < dealerships.size(); i++) {
            if (dealerships.get(i).getDealershipId() == dealershipId) {
                dealershipPos = i;
                break;
            }
        }

        if (dealershipPos == -1) {
            System.out.println("Dealership not found");
            return;
        }

        // add car to dealership
        dealerships.get(dealershipPos).getCars().add(car);
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Dealership> getDealerships() {
        return dealerships;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void clientBuysCar(int clientId, String brandName, int dealershipId) {
        // get client from clients list
        int clientPos = -1;
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getClientId() == clientId) {
                clientPos = i;
                break;
            }
        }

        int dealershipPos = -1;
        for (int i = 0; i < dealerships.size(); i++) {
            if (dealerships.get(i).getDealershipId() == dealershipId) {
                dealershipPos = i;
                break;
            }
        }

        if (clientPos == -1 || dealershipPos == -1) {
            System.out.println("Client or dealership not found");
            return;
        }
        System.out.println(clients.get(clientPos));
        System.out.println(dealerships.get(dealershipPos));

        // get car from dealership
        Car car = null;
        for (Car c : dealerships.get(dealershipPos).getCars()) {
            if (c.getBrandName().equals(brandName)) {
                car = c;
                break;
            }
        }


        if (car == null) {
            System.out.println("Car not found");
            return;
        }

        // check if client has enough money
        if (clients.get(clientPos).getMoney() < car.getPrice()) {
            System.out.println("Client does not have enough money");
            return;
        }

        // remove car from dealership
        dealerships.get(dealershipPos).getCars().remove(car);
        clients.get(clientPos).setMoney(clients.get(clientPos).getMoney() - car.getPrice());
        clients.get(clientPos).getCars().add(car);
//        Transaction t = new Transaction(car.getCarId(), car, clientId, clients.get(clientPos), dealershipId, dealerships.get(dealershipPos), new Date(), car.getPrice());
//        transactions.add(t);
//        dealerships.get(dealershipPos).getTransactions().add(t.getTransactionId());
    }



}
