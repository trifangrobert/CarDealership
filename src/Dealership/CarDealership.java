package Dealership;

import Vehicle.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDealership {
    private final int dealershipId;
    private String name;
    private String city;
    private String website;
    private List<Car> cars = new ArrayList<>();
    public CarDealership(int dealershipId, String name, String city, String website, List<Car> cars) {
        this.dealershipId = dealershipId;
        this.name = name;
        this.city = city;
        this.website = website;
        this.cars = cars;
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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "CarDealership{" +
                "dealershipId=" + dealershipId +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", website='" + website + '\'' +
                ", cars=" + cars +
                '}';
    }
}
