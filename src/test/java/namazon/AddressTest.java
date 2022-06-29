package namazon;

import namazon.accounts.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddressTest {

    @Test
    @DisplayName("Address Constructor Test")
    public void addressConstructorTest01(){
        Address address = new Address("Towson St", "1467", "Baltimore", "MD");
        String expected = "Towson St 1467 Baltimore MD";
        String actual = address.toString();
        Assertions.assertEquals(expected, actual);
    }
}
