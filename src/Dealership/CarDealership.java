package Dealership;

import Vehicle.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDealership {
    private final int dealershipId;
    private String name;
    private String city;
    private String website;

    private List<Car> cars = new ArrayList<Car>();
    private List<Transaction> transactions = new ArrayList<Transaction>();

    public CarDealership(int dealershipId, String name, String city, String website) {
        this.dealershipId = dealershipId;
        this.name = name;
        this.city = city;
        this.website = website;
    }

    public int getDealershipId() {
        return dealershipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
