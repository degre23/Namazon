package namazon;

import namazon.accounts.Account;
import namazon.accounts.Customer;
import namazon.accounts.Vendor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NamazonTest {
    @Test
    @DisplayName("Namazon Sign In As Customer Test")
    public void namazonSignInAsCustomerTes01(){
        Customer customer = new Customer("Demari", "Green", "d@g.com", "ok1");
        String expected = "Demari Green d@g.com ok1";
        String actual = customer.toString();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Namazon Sign In As Vendor Test")
    public void namazonSignInAsVendorTes01(){
        Vendor vendor = new Vendor("Demari", "Green", "d@g.com", "ok1", "DA-BOIS");
        String expected = "Demari Green d@g.com ok1 DA-BOIS";
        String actual = vendor.toString();
        Assertions.assertEquals(expected,actual);
    }
}
