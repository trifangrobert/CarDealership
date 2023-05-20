package Dealership;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class DealershipFactory {
    private static int uniqueId = 0;
    public void setUniqueId(int uniqueId) {
        DealershipFactory.uniqueId = uniqueId;
    }
    public Dealership createDealership(Scanner in) throws ParseException {
        return new Dealership(uniqueId++, in);
    }
    public Dealership createDealership(int dealershipId, Scanner in) throws ParseException {
        return new Dealership(dealershipId, in);
    }
    public Dealership createDealership(ResultSet rs) throws ParseException, SQLException {
        return new Dealership(uniqueId++, rs);
    }

    public Dealership createDealership(int dealershipId, ResultSet rs) throws ParseException, SQLException {
        return new Dealership(dealershipId, rs);
    }
}
