import Client.*;
import Dealership.*;
import Service.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

public class Main {
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/CarDealership";
            String user = "robert";
            String password = "Robert1248!";
            return DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    //
    static List<String> commands = Arrays.asList("create_client", "update_client", "delete_client", "print_clients", "create_dealership", "update_dealership", "delete_dealership", "print_dealerships", "create_car", "update_car", "delete_car", "print_cars", "print_transactions", "delete_transaction", "cars_from_dealership", "cars_from_client", "client_buys_car_from_dealership", "client_sells_car_to_dealership", "quit");
    static List<String> commandsDescription = Arrays.asList("Create a new client", "Update a client", "Delete a client", "Print all clients", "Create a new dealership", "Update a dealership", "Delete a dealership", "Print all dealerships", "Create a new car", "Update a car", "Delete a car", "Print all cars", "Print all transactions", "Delete a transaction", "Print all cars from a dealership", "Print all cars from a client", "A client buys a car from a dealership", "A client sells a car to a dealership", "Quit");

    public static void main(String[] args) throws ParseException, SQLException {
//        CarService carService = new CarService();
//        carService.addClient(new Client("Robert", "Trifan", new Address("Splaiul Independentei", "Bucuresti", "Bucuresti", 123), new Date(), 1000000, new ArrayList<>()));
//        carService.addClient(new Client("Anna", "Pecheanu", new Address("Splaiul Independentei", "Bucuresti", "Bucuresti", 123), new Date(), 1000000, new ArrayList<>()));
//        carService.addClient(new Client("Andrei", "Popescu", new Address("Strada Strazilor", "Brasov", "Brasov", 456), new Date(), 1000000, new ArrayList<>()));
//        carService.addClient(new Client("Mihai", "Ilie", new Address("Strada Strazilor", "Craiova", "Dolj", 789), new Date(), 1000000, new ArrayList<>()));
//
//        carService.addDealership(new CarDealership("Marius's Car Dealership", "Brasov", "www.andreicar.com"));
//        carService.addDealership(new CarDealership("Mihai's Car Dealership", "Craiova", "www.mihaicar.com"));
//
//        Car lamborghini_urus = new SUV("Lamborghini", 2020, "black", "VS 03 FUN", 300000, 6, 5);
//        Car ferrari_roma = new SuperCar("Ferrari", 2020, "red", "VS 02 FUN", 200000, 4, 300);
//        Car mercedes_van = new Van("Mercedes", 2020, "white", "VS 01 FUN", 100000, 4, 10);
//
//        carService.addCarToDealership(1, lamborghini_urus);
//        carService.addCarToDealership(1, ferrari_roma);
//        carService.addCarToDealership(2, mercedes_van);
//
//        System.out.println(carService.getClients());
//        System.out.println(carService.getDealerships());
//        System.out.println(carService.getTransactions());
//
//        carService.clientBuysCar(1, "Lamborghini", 1);
//
//        System.out.println(carService.getClients());
//        System.out.println(carService.getDealerships());
//        System.out.println(carService.getTransactions());

        Scanner scanner = new Scanner(System.in);
        Connection connection = Main.getConnection();
        Service service = new Service(connection);

        System.out.println("Welcome to the Car Dealership!");
        System.out.println("Type 'help' to see the list of commands.");
        System.out.println(new Date());

        boolean running = true;
        while (running) {
            System.out.println("Please enter a command: ");
            String command = scanner.nextLine();
            switch (command) {
                case "help" -> {
                    for (int i = 0; i < commands.size(); i++) {
                        System.out.println(commands.get(i) + " - " + commandsDescription.get(i));
                    }
                }
                case "refresh_database" -> service.refresh();
                case "create_client" -> service.createClient(scanner);
                case "update_client" -> service.updateClient(scanner);
                case "delete_client" -> service.deleteClient(scanner);
                case "print_client" -> service.printClient(scanner);
                case "print_clients" -> service.printClients();
                case "create_dealership" -> service.createDealership(scanner);
                case "update_dealership" -> service.updateDealership(scanner);
                case "delete_dealership" -> service.deleteDealership(scanner);
                case "print_dealership" -> service.printDealership(scanner);
                case "print_dealerships" -> service.printDealerships();
                case "create_car" -> service.createCar(scanner);
                case "update_car" -> service.updateCar(scanner);
                case "delete_car" -> service.deleteCar(scanner);
                case "print_car" -> service.printCar(scanner);
                case "print_cars" -> service.printCars();
                case "delete_transaction" -> service.deleteTransaction(scanner);
                case "print_transactions" -> service.printTransactions();
                case "print_transaction" -> service.printTransaction(scanner);
                case "cars_from_dealership" -> service.printCarsFromDealership(scanner);
                case "cars_from_client" -> service.printCarsFromClient(scanner);
                case "client_buys_car_from_dealership" -> service.clientBuysCarFromDealership(scanner);
                case "client_sells_car_to_client" -> service.clientSellsCarToClient(scanner);
                case "quit" -> running = false;
                default -> System.out.println("Invalid command!");
            }
        }

//        service.createClient(scanner);

//        int updateClientId = scanner.nextInt();
//        scanner.nextLine();
//        service.updateClient(updateClientId, scanner);

//        int deleteClientId = scanner.nextInt();
//        scanner.nextLine();
//        service.deleteClient(deleteClientId);


//        System.out.println(service.getClients());

    }
}