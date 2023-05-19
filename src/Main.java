import Client.*;
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
    static List<String> commands = Arrays.asList("create_client", "update_client", "delete_client", "print_clients", "quit");
    static List<String> commandsDescription = Arrays.asList("Create a new client", "Update a client", "Delete a client", "Print all clients", "End the program");

    public static void main(String[] args) throws ParseException, SQLException {

//        CarService carService = new CarService();
////        carService.addClient(new Client("Robert", "Trifan", new Address("Splaiul Independentei", "Bucuresti", "Bucuresti", 123), new Date(), 1000000, new ArrayList<>()));
////        carService.addClient(new Client("Anna", "Pecheanu", new Address("Splaiul Independentei", "Bucuresti", "Bucuresti", 123), new Date(), 1000000, new ArrayList<>()));
////        carService.addClient(new Client("Andrei", "Popescu", new Address("Strada Strazilor", "Brasov", "Brasov", 456), new Date(), 1000000, new ArrayList<>()));
////        carService.addClient(new Client("Mihai", "Ilie", new Address("Strada Strazilor", "Craiova", "Dolj", 789), new Date(), 1000000, new ArrayList<>()));
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

        ClientDatabase clientDatabase = new ClientDatabase(connection);

        Service service = new Service(clientDatabase);

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
                case "create_client" -> service.createClient(scanner);
                case "update_client" -> service.updateClient(scanner);
                case "delete_client" -> service.deleteClient(scanner);
                case "print_clients" -> service.printClients();
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