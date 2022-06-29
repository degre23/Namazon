package namazon;

import namazon.accounts.Account;
import namazon.accounts.Customer;
import namazon.accounts.Vendor;
import namazon.exceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Namazon {

    private final Scanner scanner = new Scanner(System.in);
    private Account currentUser;
    private List<Customer> customers;
    private List<Vendor> vendors;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Vendor> getVendors() {
        return vendors;
    }

    public void setVendors(List<Vendor> vendors) {
        this.vendors = vendors;
    }

    public Namazon() {
        this.customers = new ArrayList<>();
        this.vendors = new ArrayList<>();
    }

    public Account signIn(String email, String password) throws AccountCreationException, AccountNotValidException {
        for (Vendor vendor : vendors){
            if (vendor.getEmail().equals(email) && vendor.getPassword().equals(password)){
                return vendor;
            }
        }
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        throw new AccountNotValidException("User account is not valid");
    }

    public Vendor signUpAsVendor(String firstName, String lastName, String email, String password, String brandName) throws AccountCreationException {
        for (Vendor vendor : vendors){
            if (email.equals(vendor.getEmail())){
                throw new AccountCreationException("Username exist: " + email);

            }
        }
        Vendor vendor = new Vendor(firstName, lastName, email, password, brandName);
        vendors.add(vendor);
        return vendor;
    }

    public Customer signUpAsCustomer(String firstName, String lastName, String email, String password) throws AccountCreationException{
        for (Customer customer : customers){
            if (email.equals(customer.getEmail())){
                throw new AccountCreationException("Username exist: " + email);

            }
        }
        Customer customer = new Customer(firstName, lastName, email, password);
        customers.add(customer);
        return customer;
    }

    public Vendor selectVendor(String vendor) throws VendorNotFoundException {
        for (Vendor v : vendors){
            if (v.getBrandName().equals(vendor)){
                return v;
            }
        }
        throw new VendorNotFoundException("Vendor cannot be found.");
    }

    public void run(){
        Boolean flag = true;
        while (flag){
            if(currentUser == null)
                flag = welcomeScreen();
            else{
                userOptionsScreen();
            }
        }
    }

    private Boolean userOptionsScreen(){
        String msg = String.format("Welcome %s, here are your options", currentUser.getFirstName());
        msg += "\nPress 3 to log out";
        System.out.println(msg);
        String selection = scanner.next();
        switch (selection){
            case "3":
                currentUser = null;
                return false;
            default:
                return true;
        }

    }
    private Boolean welcomeScreen(){
        Boolean flag = true;
        String output = "Welcome to Namazon. Please select from the following options."
                +"\nPress 1 to login"
                +"\nPress 2 to create new account"
                +"\nPress 3 to exit";
        System.out.println(output);
        String selection = scanner.next();
        switch (selection){
            case "1":
                attemptSignIn();
                break;
            case "2":
                attemptSignUp();
                break;
            case "3":
            default:
                System.out.println("Good Bye");
                flag = false;
        }
        return flag;
    }

    private void attemptSignIn(){
        try {
            System.out.println("Please enter valid email:");
            String email = scanner.next();
            System.out.println("Please enter valid password");
            String password = scanner.next();
            currentUser = signIn(email, password);
        } catch (AccountCreationException e) {
            System.out.println("You entered the wrong password");
        } catch (AccountNotValidException e) {
            System.out.println("The password was incorrect");
        }

    }

    private void attemptSignUp(){
        try {
            System.out.println("Please enter first name");
            String firstName = scanner.next();
            System.out.println("Please enter last name");
            String lastName = scanner.next();
            System.out.println("Please enter email");
            String email = scanner.next();
            System.out.println("Please enter password");
            String password = scanner.next();
            currentUser = signUpAsCustomer(firstName, lastName, email, password);
        } catch (AccountCreationException e) {
            System.out.println("User with email all ready exist");
        }
    }

    public static void main(String[] args) {
        Namazon namazon = new Namazon();
        namazon.run();

    }
}
