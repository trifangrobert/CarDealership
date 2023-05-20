package Client;

import Vehicle.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Client implements Comparable<Client> {
    private final int clientId;
    private String firstName;
    private String lastName;
    private Address address;
    private Date birthDate;
    private double money;

    public List<Car> cars = new ArrayList<>();

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", money=" + money +
                ", cars =" + cars +
                ", address=" + address +
                '}';
    }

    public Client(int clientId, String firstName, String lastName, Date birthDate, double money, List<Car> cars, Address address) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.money = money;
        this.cars = cars;
        this.address = address;
    }

    public Client(int clientId, Scanner in) throws ParseException {
        this.clientId = clientId;
        this.read(in);
    }

    public void read(Scanner in) throws ParseException {
        System.out.println("First name: ");
        this.firstName = in.nextLine();
        System.out.println("Last name: ");
        this.lastName = in.nextLine();
        System.out.println("Birth date: ");
        this.birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(in.nextLine());
        System.out.println("Money: ");
        this.money = in.nextDouble();
        in.nextLine();
        System.out.println("Address: ");
        this.address = new Address(in);
    }

    public Client(int clientId, ResultSet rs) throws SQLException {
        this.clientId = clientId;
        this.read(rs);
    }

    public void read(ResultSet rs) throws SQLException {
        this.firstName = rs.getString("first_name");
        this.lastName  = rs.getString("last_name");
        this.birthDate = rs.getDate("birthdate");
        this.money     = rs.getDouble("money");
        this.address   = new Address(rs);
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
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    public List<Car> getCars() {
        return cars;
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    public void addCar(Car car) {
        this.cars.add(car);
    }
    @Override
    public int compareTo(Client o) {
        return (int) (o.getMoney() - this.getMoney());
    }
}
