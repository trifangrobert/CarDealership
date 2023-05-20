import Service.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

import Service.AuditSingleton;

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
    static List<String> commands = Arrays.asList("create_client", "update_client", "delete_client", "print_client", "print_clients", "create_dealership", "update_dealership", "delete_dealership", "print_dealership", "print_dealerships", "create_car", "update_car", "delete_car", "print_car", "print_cars", "print_transaction", "print_transactions", "delete_transaction", "cars_from_dealership", "cars_from_client", "client_buys_car_from_dealership", "client_sells_car_to_dealership", "refresh", "print_richest_clients", "quit");
    static List<String> commandsDescription = Arrays.asList("Create a client", "Update a client", "Delete a client", "Print a client", "Print all clients", "Create a dealership", "Update a dealership", "Delete a dealership", "Print a dealership", "Print all dealerships", "Create a car", "Update a car", "Delete a car", "Print a car", "Print all cars", "Print a transaction", "Print all transactions", "Delete a transaction", "Print all cars from a dealership", "Print all cars from a client", "A client buys a car from a dealership", "A client sells a car to a client", "Refresh the database", "Print the richest clients", "Quit the program");

    public static void main(String[] args) throws ParseException, SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = Main.getConnection();
        Service service = new Service(connection);
        AuditSingleton.getInstance();

        System.out.println("Welcome to the Car Dealership!");
        System.out.println("Type 'help' to see the list of commands.");

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
                case "refresh_database" -> {
                    service.refresh();
                    AuditSingleton.getInstance().add("refresh_database");
                }
                case "create_client" -> {
                    service.createClient(scanner);
                    AuditSingleton.getInstance().add("create_client");
                }
                case "update_client" -> {
                    service.updateClient(scanner);
                    AuditSingleton.getInstance().add("update_client");
                }
                case "delete_client" -> {
                    service.deleteClient(scanner);
                    AuditSingleton.getInstance().add("delete_client");
                }
                case "print_client" -> {
                    service.printClient(scanner);
                    AuditSingleton.getInstance().add("print_client");
                }
                case "print_clients" -> {
                    service.printClients();
                    AuditSingleton.getInstance().add("print_clients");
                }
                case "create_dealership" -> {
                    service.createDealership(scanner);
                    AuditSingleton.getInstance().add("create_dealership");
                }
                case "update_dealership" -> {
                    service.updateDealership(scanner);
                    AuditSingleton.getInstance().add("update_dealership");
                }
                case "delete_dealership" -> {
                    service.deleteDealership(scanner);
                    AuditSingleton.getInstance().add("delete_dealership");
                }
                case "print_dealership" -> {
                    service.printDealership(scanner);
                    AuditSingleton.getInstance().add("print_dealership");
                }
                case "print_dealerships" -> {
                    service.printDealerships();
                    AuditSingleton.getInstance().add("print_dealerships");
                }
                case "create_car" -> {
                    service.createCar(scanner);
                    AuditSingleton.getInstance().add("create_car");
                }
                case "update_car" -> {
                    service.updateCar(scanner);
                    AuditSingleton.getInstance().add("update_car");
                }
                case "delete_car" -> {
                    service.deleteCar(scanner);
                    AuditSingleton.getInstance().add("delete_car");
                }
                case "print_car" -> {
                    service.printCar(scanner);
                    AuditSingleton.getInstance().add("print_car");
                }
                case "print_cars" -> {
                    service.printCars();
                    AuditSingleton.getInstance().add("print_cars");
                }
                case "delete_transaction" -> {
                    service.deleteTransaction(scanner);
                    AuditSingleton.getInstance().add("delete_transaction");
                }
                case "print_transactions" ->{
                    service.printTransactions();
                    AuditSingleton.getInstance().add("print_transactions");
                }
                case "print_transaction" -> {
                    service.printTransaction(scanner);
                    AuditSingleton.getInstance().add("print_transaction");
                }
                case "cars_from_dealership" -> {
                    service.printCarsFromDealership(scanner);
                    AuditSingleton.getInstance().add("cars_from_dealership");
                }
                case "cars_from_client" -> {
                    service.printCarsFromClient(scanner);
                    AuditSingleton.getInstance().add("cars_from_client");
                }
                case "client_buys_car_from_dealership" -> {
                    service.clientBuysCarFromDealership(scanner);
                    AuditSingleton.getInstance().add("client_buys_car_from_dealership");
                }
                case "client_sells_car_to_client" -> {
                    service.clientSellsCarToClient(scanner);
                    AuditSingleton.getInstance().add("client_sells_car_to_client");
                }
                case "print_richest_clients" -> {
                    service.printRichestClients();
                    AuditSingleton.getInstance().add("print_richest_clients");
                }
                case "quit" -> {
                    running = false;
                    AuditSingleton.getInstance().add("quit");
                }
                default -> System.out.println("Invalid command!");
            }
        }
        connection.close();
        AuditSingleton.getInstance().dumpToCSV();
    }
}