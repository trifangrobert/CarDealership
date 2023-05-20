package Dealership;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionFactory {
    private static int uniqueId = 0;
    public void setUniqueId(int uniqueId) {
        TransactionFactory.uniqueId = uniqueId;
    }
    public Transaction createTransaction(int carId, int clientId, int dealershipId) {
        return new Transaction(uniqueId++, carId, clientId, dealershipId);
    }
    public Transaction createTransaction(int transactionId, ResultSet rs) throws SQLException {
        return new Transaction(transactionId, rs);
    }
}
