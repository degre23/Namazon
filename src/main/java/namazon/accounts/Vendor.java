package namazon.accounts;

import namazon.exceptions.ProductNotAvailableException;
import namazon.order.Order;
import namazon.product.Product;
import namazon.product.ProductCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vendor extends Account {
    private String brandName;
    private Map<Product, Integer> inventory;
    private List<Order> orders;
    private Product[] showCase;


    public Vendor(String firstName, String lastName, String email, String password, String brandName) {
        super(firstName, lastName, email, password);
        this.inventory = new HashMap<>();
        this.orders = new ArrayList<>();
        this.showCase = new Product[5];
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void addProduct(Product product){
        if(inventory.containsKey(product)){
            Integer currentCount = inventory.get(product) + 1;
            inventory.put(product, currentCount);
        }else {
            inventory.put(product, 1);
        }

    }

    public boolean removeProduct(Product product){
        if(inventory.containsKey(product)){
            inventory.remove(product);
            return true;
        }
        return false;
    }

    public boolean cancelOrder(Order order){
        if (orders.contains(order)){
            orders.remove(order);
            return true;
        }
        return false;
    }

    public Map<Product, Integer> getInventory() {
        return inventory;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addProductToShowcase(){
    }

    public Product[] getShowCase() {
        return showCase;
    }

    public List<Product> searchByCategory(ProductCategory category) throws ProductNotAvailableException {
        List<Product> searched = new ArrayList<>();
        for (Product lookForProduct : inventory.keySet()) {
            ProductCategory looking = lookForProduct.getCategory();
            if (looking.name().equals(category.name())) {
                searched.add(lookForProduct);

            } else {
                throw new ProductNotAvailableException("This product is not available right now.");
            }

        }
        return searched;
    }

    public Product purchase(){
        return null;
    }

    @Override
    public String toString() {
        return String.format("%s %s",super.toString(),brandName);
    }
}


