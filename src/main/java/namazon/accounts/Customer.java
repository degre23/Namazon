package namazon.accounts;

public class Customer extends Account{
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public Customer(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
