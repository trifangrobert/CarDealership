package Client;

import java.util.ArrayList;
import java.util.List;

public class ClientSingletone {
    private static ClientSingletone instance = null;
    private List<Client> clients = new ArrayList<Client>();
    private ClientFactory clientFactory = new ClientFactory();
    private ClientSingletone() {}
    public static ClientSingletone getInstance() {
        if (instance == null) {
            instance = new ClientSingletone();
        }
        return instance;
    }
    public List<Client> getClients() {
        return clients;
    }
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

}
