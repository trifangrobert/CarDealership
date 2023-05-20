package Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class ClientFactory {
    private static int uniqueId = 0;
    public void setUniqueId(int uniqueId) {
        ClientFactory.uniqueId = uniqueId;
    }
    public Client createClient(Scanner in) throws ParseException {
        return new Client(uniqueId++, in);
    }
    public Client createClient(int clientId, Scanner in) throws ParseException {
        return new Client(clientId, in);
    }
    public Client createClient(ResultSet rs) throws ParseException, SQLException {
        return new Client(uniqueId++, rs);
    }
    public Client createClient(int clientId, ResultSet rs) throws ParseException, SQLException {
        return new Client(clientId, rs);
    }
}
