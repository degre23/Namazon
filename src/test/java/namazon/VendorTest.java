package namazon;

import namazon.accounts.Address;
import namazon.accounts.Vendor;
import namazon.order.Order;
import namazon.order.OrderStatus;
import namazon.product.Product;
import namazon.product.ProductCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class VendorTest {
    @Test
    @DisplayName("Vendor test")
    public void vendorConstructorTest01(){
    Vendor vendor = new Vendor("Susan", "McGregor","SSgregor@gmail.com",
            "butterf1y", "Blooming");
    String expected = "Susan McGregor SSgregor@gmail.com butterf1y Blooming";
    String actual = vendor.toString();
    Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Add product Vendor test")
    public void addProductToVendorTest01(){
        Vendor vendor = new Vendor("Susan", "McGregor","SSgregor@gmail.com",
                "butterf1y", "Blooming");
        vendor.addProduct(new Product("Dress", 45.0, ProductCategory.CLOTHING));
        Integer expected = 1;
        Integer actual = vendor.getInventory().size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Remove product Vendor test")
    public void removeProductToVendorTest01(){
        Product product = new Product("Dress", 45.0, ProductCategory.CLOTHING);
        Vendor vendor = new Vendor("Susan", "McGregor","SSgregor@gmail.com",
                "butterf1y", "Blooming");
        vendor.addProduct(product);
        vendor.removeProduct(product);
        Integer expected = 0;
        Integer actual = vendor.getInventory().size();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Cancel Orders test")
    public void cancelOrdersTest01(){
        Order order = new Order(new Product("Deamri", 30.0, ProductCategory.CLOTHING),
                new Address("Towson", "1500", "baltimore","MD"), OrderStatus.SHIPPED);
        Vendor vendor = new Vendor("Demari", "Green", "dg@gmail.com", "ok1","Green's");
        vendor.getOrders().add(order);
        Assertions.assertTrue(vendor.cancelOrder(order));
    }
}
