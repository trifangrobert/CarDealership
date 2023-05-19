package Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Address {
    private String street;
    private String city;
    private String state;
    private int zip;

    public Address(String street, String city, String state, int zip) {
        this.street = street;
        this.city   = city;
        this.state  = state;
        this.zip    = zip;
    }

    public Address(Scanner in) throws ParseException {
        this.read(in);
    }
    public void read(Scanner in) throws ParseException {
        System.out.println("Street: ");
        this.street = in.nextLine();
        System.out.println("City: ");
        this.city = in.nextLine();
        System.out.println("State: ");
        this.state = in.nextLine();
        System.out.println("Zip: ");
        this.zip = Integer.parseInt(in.nextLine());
    }
    public Address(ResultSet rs) throws SQLException {
        this.read(rs);
    }
    public void read(ResultSet rs) throws SQLException {
        this.street = rs.getString("street");
        this.city   = rs.getString("city");
        this.state  = rs.getString("state");
        this.zip    = rs.getInt("zip");
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public int getZip() {
        return zip;
    }
}
