package namazon;

import namazon.accounts.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    @DisplayName("Customer test")

    public void customerConstructorTest01(){
        Customer customer = new Customer("Demari", "Green", "dgreen100@gmail.com", "wasd1234");
        String expected= "Demari Green dgreen100@gmail.com wasd1234";
        String actual = customer.toString();
        Assertions.assertEquals(expected,actual);

    }
}
