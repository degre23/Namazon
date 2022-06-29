package namazon.accounts;

public abstract class Account {

    private static Long idCount = 1L;
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public Account(String firstName, String lastName, String email, String password) {
        this.id = idCount++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public static Long getIdCount(){
        return idCount;
    }

    public static void setIdCount(Long idCount){
        Account.idCount = idCount;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return String.format("%s %s %s %s", firstName, lastName, email, password);
    }
}


