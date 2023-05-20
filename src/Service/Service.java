package Service;

import Client.*;
import Dealership.*;

import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    private List<Client> clients = new ArrayList<>();
    private List<Dealership> dealerships = new ArrayList<>();

    private final ClientFactory clientFactory = new ClientFactory();
    private final DealershipFactory dealershipFactory = new DealershipFactory();
    public Service(Connection connection) {
        ClientDatabase.getInstance();
        ClientDatabase.setConnection(connection);
        clientFactory.setUniqueId(ClientDatabase.getMaxId() + 1);

        DealershipDatabase.getInstance();
        DealershipDatabase.setConnection(connection);
        dealershipFactory.setUniqueId(DealershipDatabase.getMaxId() + 1);

        this.clients = ClientDatabase.read();
        this.dealerships = DealershipDatabase.read();
    }
    public List<Client> getClients() {
        return clients;
    }
    public List<Dealership> getDealerships() {
        return dealerships;
    }
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    public void setDealerships(List<Dealership> dealerships) {
        this.dealerships = dealerships;
    }

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
    }

    public void updateDealership(Scanner in) throws ParseException {
        System.out.println("Enter dealership id: ");
        int dealershipId = in.nextInt();
        in.nextLine();
        Dealership dealership = dealershipFactory.createDealership(dealershipId, in);
        dealerships.removeIf(d -> d.getDealershipId() == dealership.getDealershipId());
        dealerships.add(dealership);
        DealershipDatabase.update(dealership);
    }

    public void deleteDealership(Scanner in) throws ParseException {
        System.out.println("Enter dealership id: ");
        int dealershipId = in.nextInt();
        in.nextLine();
        dealerships.removeIf(dealership -> dealership.getDealershipId() == dealershipId);
        DealershipDatabase.delete(dealershipId);
    }
}
