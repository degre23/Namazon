package namazon;

import namazon.accounts.Address;
import namazon.order.Order;
import namazon.order.OrderStatus;
import namazon.product.Product;
import namazon.product.ProductCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    @DisplayName("Checking the customer's order test")
    public void orderConstructorTest01(){
        Order order = new Order(new Product("Deamri", 30.0, ProductCategory.CLOTHING),
                new Address("Towson", "1500", "baltimore","MD"),OrderStatus.SHIPPED);
        String expected = "1500 baltimore MD SHIPPED";
        String actual = order.toString();
        Assertions.assertEquals(expected, actual);

    }

}
