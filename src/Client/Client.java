package Client;

import Vehicle.Car;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client {
    private final int clientId;
    private String firstName;
    private String lastName;
    private Address address;
    private Date birthDate;
    private int money;

    public List<Car> vehicles = new ArrayList<Car>();
    public Client(int clientId, String firstName, String lastName, Address address, Date birthDate, int money) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthDate = birthDate;
        this.money = money;
    }
    public int getClientId() {
        return clientId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
}
