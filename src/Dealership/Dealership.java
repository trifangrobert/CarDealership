package Dealership;

import Vehicle.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealership {
    private final int dealershipId;
    private String dealerName;
    private String city;
    private String website;
    private List<Car> cars = new ArrayList<>();

    public Dealership(int dealershipId, String dealerName, String city, String website, List<Car> cars) {
        this.dealershipId = dealershipId;
        this.dealerName = dealerName;
        this.city = city;
        this.website = website;
        this.cars = cars;
    }

    public Dealership(int dealershipId, Scanner in) {
        this.dealershipId = dealershipId;
        this.read(in);
    }

    public void read(Scanner in) {
        System.out.println("Dealer name: ");
        this.dealerName = in.nextLine();
        System.out.println("City: ");
        this.city = in.nextLine();
        System.out.println("Website: ");
        this.website = in.nextLine();
    }

    public Dealership(int dealershipId, ResultSet rs) throws SQLException {
        this.dealershipId = dealershipId;
        this.read(rs);
    }
    public void read(ResultSet rs) throws SQLException {
        this.dealerName = rs.getString("dealer_name");
        this.city = rs.getString("city");
        this.website = rs.getString("website");
    }

    public int getDealershipId() {
        return dealershipId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "dealershipId=" + dealershipId +
                ", dealerName='" + dealerName + '\'' +
                ", city='" + city + '\'' +
                ", website='" + website + '\'' +
                ", cars=" + cars +
                '}';
    }
}
