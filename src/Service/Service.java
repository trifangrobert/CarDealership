package Service;

import Client.*;
import Dealership.*;
import Vehicle.*;

import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Service {
    private List<Client> clients = new ArrayList<>();
    private List<Dealership> dealerships = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    private final ClientFactory clientFactory = new ClientFactory();
    private final DealershipFactory dealershipFactory = new DealershipFactory();
    private final CarFactory carFactory = new CarFactory();
    private final TransactionFactory transactionFactory = new TransactionFactory();

    public Service(Connection connection) {
        ClientDatabase.getInstance();
        ClientDatabase.setConnection(connection);
        clientFactory.setUniqueId(ClientDatabase.getMaxId() + 1);

        DealershipDatabase.getInstance();
        DealershipDatabase.setConnection(connection);
        dealershipFactory.setUniqueId(DealershipDatabase.getMaxId() + 1);

        CarDatabase.getInstance();
        CarDatabase.setConnection(connection);
        carFactory.setUniqueId(CarDatabase.getMaxId() + 1);

        TransactionDatabase.getInstance();
        TransactionDatabase.setConnection(connection);
        transactionFactory.setUniqueId(TransactionDatabase.getMaxId() + 1);

        this.clients = ClientDatabase.read();
        this.dealerships = DealershipDatabase.read();
        this.cars = CarDatabase.read();
        this.transactions = TransactionDatabase.read();

        linkCars();
    }
    public void linkCars() {
        for (Car car : cars) {
            if (car.getIsAvailable()) {
                for (Dealership dealership : dealerships) {
                    if (dealership.getDealershipId() == car.getOwnerId()) {
                        dealership.addCar(car);
                    }
                }
            }
            else {
                for (Client client : clients) {
                    if (client.getClientId() == car.getOwnerId()) {
                        client.addCar(car);
                    }
                }
            }
        }
    }
    public void refresh() {
        this.clients = ClientDatabase.read();
        this.dealerships = DealershipDatabase.read();
        this.cars = CarDatabase.read();
        this.transactions = TransactionDatabase.read();

        linkCars();

    }
    public List<Client> getClients() {
        return clients;
    }
    public List<Dealership> getDealerships() {
        return dealerships;
    }
    public List<Car> getCars() { return cars; }
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    public void setDealerships(List<Dealership> dealerships) {
        this.dealerships = dealerships;
    }
    public void setCars(List<Car> cars) { this.cars = cars; }

    //actions
    public void printClients() {
        System.out.println(clients);
    }
    public void createClient(Scanner in) throws ParseException {
        Client client = clientFactory.createClient(in);
        clients.add(client);
        ClientDatabase.create(client);
    }

    public void updateClient(Scanner in) throws ParseException {
        System.out.println("Enter client id: ");
        int clientId = in.nextInt();
        in.nextLine();
        Client client = clientFactory.createClient(clientId, in);
        clients.removeIf(c -> c.getClientId() == client.getClientId());
        clients.add(client);
        ClientDatabase.update(client);
    }

    public void deleteClient(Scanner in) throws ParseException {
        System.out.println("Enter client id: ");
        int clientId = in.nextInt();
        in.nextLine();
        clients.removeIf(client -> client.getClientId() == clientId);
        ClientDatabase.delete(clientId);
    }

    public void printDealerships() {
        System.out.println(dealerships);
    }
    public void createDealership(Scanner in) throws ParseException {
        Dealership dealership = dealershipFactory.createDealership(in);
        dealerships.add(dealership);
        DealershipDatabase.create(dealership);

        this.refresh();
    }

    public void updateDealership(Scanner in) throws ParseException {
        System.out.println("Enter dealership id: ");
        int dealershipId = in.nextInt();
        in.nextLine();
        Dealership dealership = dealershipFactory.createDealership(dealershipId, in);
        dealerships.removeIf(d -> d.getDealershipId() == dealership.getDealershipId());
        dealerships.add(dealership);
        DealershipDatabase.update(dealership);

        this.refresh();
    }

    public void deleteDealership(Scanner in) throws ParseException {
        System.out.println("Enter dealership id: ");
        int dealershipId = in.nextInt();
        in.nextLine();
        dealerships.removeIf(dealership -> dealership.getDealershipId() == dealershipId);
        DealershipDatabase.delete(dealershipId);

        this.refresh();
    }

    public void printCars() {
        System.out.println(cars);
    }

    public void createCar(Scanner in) throws ParseException {
        Car car = carFactory.createCar(in);
        cars.add(car);
        CarDatabase.create(car);

        this.refresh();
    }

    public void updateCar(Scanner in) throws ParseException {
        System.out.println("Enter car id: ");
        int carId = in.nextInt();
        in.nextLine();
        //get the car with the given carId
        Car prevCar = cars.stream().filter(c -> c.getCarId() == carId).findFirst().orElse(null);
        Car car = carFactory.createCar(carId, prevCar.getLicensePlate(), prevCar.getIsAvailable(), prevCar.getOwnerId(), in);
        cars.removeIf(c -> c.getCarId() == car.getCarId());
        cars.add(car);
        CarDatabase.update(car);

        this.refresh();
    }

    public void deleteCar(Scanner in) throws ParseException {
        System.out.println("Enter car id: ");
        int carId = in.nextInt();
        in.nextLine();
        cars.removeIf(car -> car.getCarId() == carId);
        CarDatabase.delete(carId);

        this.refresh();
    }

    public void printTransactions() {
        System.out.println(transactions);
    }

    public void deleteTransaction(Scanner in) throws ParseException {
        System.out.println("Enter transaction id: ");
        int transactionId = in.nextInt();
        in.nextLine();
        transactions.removeIf(transaction -> transaction.getTransactionId() == transactionId);
        TransactionDatabase.delete(transactionId);

        this.refresh();
    }

    public void printCarsFromDealership(Scanner in) throws ParseException {
        System.out.println("Enter dealership id: ");
        int dealershipId = in.nextInt();
        in.nextLine();
        List<Car> carsFromDealership = cars.stream().filter(c -> c.getIsAvailable() && c.getOwnerId() == dealershipId).collect(Collectors.toList());
        System.out.println(carsFromDealership);
    }

    public void printCarsFromClient(Scanner in) throws ParseException {
        System.out.println("Enter client id: ");
        int clientId = in.nextInt();
        in.nextLine();
        List<Car> carsFromClient = cars.stream().filter(c -> !c.getIsAvailable() && c.getOwnerId() == clientId).collect(Collectors.toList());
        System.out.println(carsFromClient);
    }
    public void clientBuysCarFromDealership(Scanner in) throws ParseException {
        System.out.println("Enter client id: ");
        int clientId = in.nextInt();
        in.nextLine();
        System.out.println("Enter dealership id: ");
        int dealershipId = in.nextInt();
        in.nextLine();
        System.out.println("Enter car id: ");
        int carId = in.nextInt();
        in.nextLine();
        Transaction transaction = transactionFactory.createTransaction(clientId, dealershipId, carId);
        transactions.add(transaction);
        TransactionDatabase.create(transaction);

        Car car = cars.stream().filter(c -> c.getCarId() == carId).findFirst().orElse(null);
        car.setOwnerId(clientId);
        car.setIsAvailable(false);
        CarDatabase.update(car);

        this.refresh();
    }

    public void printClient(Scanner in) throws ParseException {
        System.out.println("Enter client id: ");
        int clientId = in.nextInt();
        in.nextLine();
        Client client = clients.stream().filter(c -> c.getClientId() == clientId).findFirst().orElse(null);
        System.out.println(client);
    }

    public void printDealership(Scanner in) throws ParseException {
        System.out.println("Enter dealership id: ");
        int dealershipId = in.nextInt();
        in.nextLine();
        Dealership dealership = dealerships.stream().filter(d -> d.getDealershipId() == dealershipId).findFirst().orElse(null);
        System.out.println(dealership);
    }

    public void printCar(Scanner in) throws ParseException {
        System.out.println("Enter car id: ");
        int carId = in.nextInt();
        in.nextLine();
        Car car = cars.stream().filter(c -> c.getCarId() == carId).findFirst().orElse(null);
        System.out.println(car);
    }

    public void printTransaction(Scanner in) throws ParseException {
        System.out.println("Enter transaction id: ");
        int transactionId = in.nextInt();
        in.nextLine();
        Transaction transaction = transactions.stream().filter(t -> t.getTransactionId() == transactionId).findFirst().orElse(null);
        System.out.println(transaction);
    }

    public void clientSellsCarToClient(Scanner in) throws ParseException {
        System.out.println("Enter seller id: ");
        int sellerId = in.nextInt();
        in.nextLine();

        System.out.println("Enter buyer id: ");
        int buyerId = in.nextInt();
        in.nextLine();

        System.out.println("Enter car id: ");
        int carId = in.nextInt();
        in.nextLine();
//        Transaction transaction = transactionFactory.createTransaction(clientId, clientId, carId);
//        transactions.add(transaction);
//        TransactionDatabase.create(transaction);

        Car car = cars.stream().filter(c -> c.getCarId() == carId).findFirst().orElse(null);
        car.setOwnerId(buyerId);
        car.setIsAvailable(false);
        CarDatabase.update(car);

        this.refresh();
    }

}
